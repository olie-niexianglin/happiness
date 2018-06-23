/**
 * option desc:分页插件
 * for example : 前一页 1 ... 3,4,5 ... 7 后一页
 * num_display_entries : 3 即 [3,4,5] 分页插件中间显示的页码尺寸
 * prev_text : 前一页索引显示的[字符串]
 * ellipse_text : 分页组件中省略的索引显示的[字符串]
 */
jQuery.fn.myPagination = function (maxentries, opts) {
    opts = jQuery.extend({
        items_per_page: 10,//每页显示的条数
        num_display_entries: 10,//分页插件中间显示的页码尺寸
        current_page: 0,//当前显示页码
        num_edge_entries: 0,//分页组件前导后导显示的页码尺寸
        link_to: "",
        prev_text: "Prev",//前一页索引显示的[字符串]
        next_text: "Next",//后一页索引显示的[字符串]
        ellipse_text: "...",//分页组件中省略的索引显示的[字符串]
        prev_show_always: true,//是否显示前一页
        next_show_always: true,//是否显示后一页
        callback: function () {//分页组件点击回调函数
            return false;
        }
    }, opts || {});

    return this.each(function () {
        /**
         * 计算最大分页显示数目
         */
        function numPages() {
            return Math.ceil(maxentries / opts.items_per_page);
        }

        /**
         * 前端分页的起始和结束点，这取决于current_page 和 num_display_entries.
         * @返回 {数组(Array)}
         */
        function getInterval() {
            var ne_half = Math.ceil(opts.num_display_entries / 2); //得到前端分页显示索引数字的一半
            var np = numPages();
            var upper_limit = np - opts.num_display_entries;
            var start = current_page > ne_half ? Math.max(Math.min(current_page - ne_half, upper_limit), 0) : 0;
            var end = current_page > ne_half ? Math.min(current_page + ne_half, np) : Math.min(opts.num_display_entries, np);
            return [start, end];
        }

        /**
         * 分页链接事件处理函数
         * @参数 {int} page_id 为新页码
         */
        function pageSelected(page_id, evt) {
            current_page = page_id;
            drawLinks();
            var continuePropagation = opts.callback(page_id, panel);
            if (!continuePropagation) {
                if (evt.stopPropagation) {
                    evt.stopPropagation();
                }
                else {
                    evt.cancelBubble = true;
                }
            }
            return continuePropagation;
        }

        /**
         * 此函数将分页链接插入到容器元素中
         */
        function drawLinks() {
            panel.empty();
            var interval = getInterval();
            var np = numPages();
            // 这个辅助函数返回一个处理函数调用有着正确page_id的pageSelected。
            var getClickHandler = function (page_id) {
                return function (evt) {
                    return pageSelected(page_id, evt);
                }
            }
            //辅助函数用来产生一个单链接(如果不是当前页则产生span标签)
            var appendItem = function (page_id, appendopts) {
                page_id = page_id < 0 ? 0 : (page_id < np ? page_id : np - 1); // 规范page id值
                appendopts = jQuery.extend({text: page_id + 1, classes: ""}, appendopts || {});
                if (page_id == current_page) {
                    var lnk = jQuery("<span class='current'>" + (appendopts.text) + "</span>");
                } else {
                    var lnk = jQuery("<a>" + (appendopts.text) + "</a>")
                        .bind("click", getClickHandler(page_id))
                        .attr('href', opts.link_to.replace(/__id__/, page_id));
                }
                if (appendopts.classes) {
                    lnk.addClass(appendopts.classes);
                }
                panel.append(lnk);
            }
            // 产生"Previous"-链接
            if (opts.prev_text && (current_page > 0 || opts.prev_show_always)) {
                appendItem(current_page - 1, {text: opts.prev_text, classes: "prev"});
            }
            // 产生起始点
            if (interval[0] > 0 && opts.num_edge_entries > 0) {
                var end = Math.min(opts.num_edge_entries, interval[0]);
                for (var i = 0; i < end; i++) {
                    appendItem(i);
                }
                if (opts.num_edge_entries < interval[0] && opts.ellipse_text) {
                    jQuery("<span>" + opts.ellipse_text + "</span>").appendTo(panel);
                }
            }
            // 产生内部的些链接
            for (var i = interval[0]; i < interval[1]; i++) {
                appendItem(i);
            }
            // 产生结束点
            if (interval[1] < np && opts.num_edge_entries > 0) {
                if (np - opts.num_edge_entries > interval[1] && opts.ellipse_text) {
                    jQuery("<span>" + opts.ellipse_text + "</span>").appendTo(panel);
                }
                var begin = Math.max(np - opts.num_edge_entries, interval[1]);
                for (var i = begin; i < np; i++) {
                    appendItem(i);
                }

            }
            // 产生 "Next"-链接
            if (opts.next_text && (current_page < np - 1 || opts.next_show_always)) {
                appendItem(current_page + 1, {text: opts.next_text, classes: "next"});
            }
        }

        //从选项中提取current_page
        var current_page = opts.current_page;
        //创建一个显示条数和每页显示条数值
        // !0 !undefined !false !null = true
        maxentries = (!maxentries || maxentries < 0) ? 1 : maxentries;
        opts.items_per_page = (!opts.items_per_page || opts.items_per_page < 0) ? 1 : opts.items_per_page;
        //存储DOM元素，以方便从所有的内部结构中获取
        var panel = jQuery(this);
        // 获得附加功能的元素
        this.selectPage = function (page_id) {
            pageSelected(page_id);
        }
        this.prevPage = function () {
            if (current_page > 0) {
                pageSelected(current_page - 1);
                return true;
            }
            else {
                return false;
            }
        }
        this.nextPage = function () {
            if (current_page < numPages() - 1) {
                pageSelected(current_page + 1);
                return true;
            }
            else {
                return false;
            }
        }
        // 所有初始化完成，绘制链接
        drawLinks();
        // 回调函数
        opts.callback(current_page, this);
    });
}


/**
 * 使用方式，需要结合 pagination.css 使用
 *
 var limit =${limit}//每页显示多少条数据
 var count =${count}//共多少条数据
 var index = ${index};//当前记录数

 $(document).ready(function () {

            initOrderPager();

     });


 function initOrderPager() {

            $("#pager").mypagination(count, {
                items_per_page: limit, // 每页显示多少条记录
                current_page: Math.ceil(index / limit),  //当前页
                num_display_entries: 2, // 分页显示的条目数
                next_text: "后一页",
                prev_text: "前一页",
                num_edge_entries: 1, // 连接分页主体，显示的条目数
                callback: handlePaginationClick
            });

          }

 function handlePaginationClick(new_page_index, pagination_container) {

            if (new_page_index != Math.ceil(index / limit)) {
                window.location.href = "myIntegralOrder.htm?index=" + new_page_index * limit;
            } else {
                //do nothing
            }
            return false;

     }
 *
 *
 *
 */


/**
 * 倒计时插件
 */

jQuery.fn.myTimecountdown = function (opts) {
    opts = jQuery.extend({
        timelong: 60,//秒
        format: "day天hour时minute分second秒",
        callback: function () {//倒计时结束回调函数
            return false;
        }
    }, opts || {});

    return this.each(function () {

        var showSpan = jQuery(this);

        //绘制内容
        function draws() {
            var interval = setInterval(function () {
                if (opts.timelong > 0) {
                    showSpan.text(secondFormate());
                    opts.timelong--;
                } else {
                    clearInterval(interval);
                    opts.callback();
                }

            }, 1000);
        }

        //将秒数转化为格式化时间
        function secondFormate() {
            var day = 0;
            var hour = 0;
            var minute = 0;
            var second = parseInt(opts.timelong) % 60;
            minute = parseInt(opts.timelong / 60);
            if (minute > 60) {
                minute = parseInt(opts.timelong / 60) % 60;
                hour = parseInt(parseInt(opts.timelong / 60) / 60);
                if (hour > 24) {
                    hour = parseInt(parseInt(opts.timelong / 60) / 60) % 24;
                    day = parseInt(parseInt(parseInt(opts.timelong / 60) / 60) / 24);
                }
            }
            var dateString = opts.format;
            if (dateString.indexOf("day") != -1)
                dateString = dateString.replace("day", day);
            if (dateString.indexOf("hour") != -1)
                dateString = dateString.replace("hour", hour);
            if (dateString.indexOf("minute") != -1)
                dateString = dateString.replace("minute", minute);
            if (dateString.indexOf("second") != -1)
                dateString = dateString.replace("second", second);
            return dateString;
        }

        draws();
    });

}


/**
 * 校验手机号
 */
jQuery.myMobilevalidate = function (phone) {
    try {
        var pattern = /^1[34578]\d{9}$/;
        return pattern.test(phone);
    } catch (e) {
        return false;
    }
}


/**
 * 20180929121314 -> 12:13:14
 */
jQuery.myGetHMfromDateTimeStr = function (datetimeStr) {
    if (datetimeStr && datetimeStr.length >= 14) {
        return datetimeStr.substring(8, 10) + ':' + datetimeStr.substring(10, 12) + ':' + datetimeStr.substring(12, 14)
    } else {
        return "unkown";
    }
}


/**
 * 320 -> 5分20秒
 */
jQuery.mySecond2Datetime = function (second) {
    if (second && !isNaN(Number(second))) {
        var _second = Number(second)
        return '' + (Math.floor(_second / 60) > 0 ? Math.floor(_second / 60) + '分' : '') + (_second % 60 > 0 ? _second % 60 + '秒' : '');
    } else {
        return "unkown";
    }
}
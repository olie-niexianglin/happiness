package olie.knowledgepoint;

/**
 * @Auther: niexianglin you can mail to niexl@inspur.com
 * @Date: 2018/7/23 16:17
 * @Description:
 */
public class SmallKnowledgePoint {

    public static void main(String[] args) {
        breakJumpOutWhile();
    }

    /**
     * @desc: break 跳出 while 循环：虽然在意料之中，但是还是有点惊讶
     * @param: []
     * @return: void
     * @auther: niexianglin mail:niexl@inspur.com
     * @date: 2018/7/23 16:19
     */
    private static void breakJumpOutWhile() {
        int i = 0;
        while (true) {
            if (i++ < 100) {
                System.out.println("index i is :" + i);
            } else {
                break;
            }
        }
        System.out.println("end");
    }
}

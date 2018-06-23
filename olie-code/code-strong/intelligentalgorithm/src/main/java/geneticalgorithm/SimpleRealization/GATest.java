package geneticalgorithm.SimpleRealization;

/**
 * Created by niexianglin on 2016/9/23 9:48
 * Class Description:
 *                       Population – 一个种群，管理所有的个体
                         Individual – 个体，包含一个基因序列
                         Algorithm – 算法类，进行遗传算法的主要操作
                         FitnessCalc – 辅助类，计算个体的适应值等
                         GATest- 测试类
 */
public class GATest {
    public static void main(String[] args) {

        // 设定一个候选解
        FitnessCalc.setSolution("1111000000000000000000000000000000000000000000000000000000001111");

        // 初始化一个种群
        Population myPop = new Population(50, true);

        // 种群进化
        int generationCount = 0;
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            myPop.displayPopulation();
            myPop = Algorithm.evolvePopulation(myPop);
        }
        System.out.println("Solution has found! and the fittest = "+ myPop.getFittest().getFitness());
        System.out.println("Generation number: " + generationCount);
        System.out.println("Genes:"+myPop.getFittest());
    }
}

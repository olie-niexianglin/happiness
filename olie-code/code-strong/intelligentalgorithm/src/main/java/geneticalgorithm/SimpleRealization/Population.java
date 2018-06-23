package geneticalgorithm.SimpleRealization;

/*
    种群类:主要作用是初始化指定个数的种群个体
*/
public class Population {

    Individual[] individuals;

    /* 创建一个种群 */
    public Population(int populationSize, boolean initialise) {
        individuals = new Individual[populationSize];
        /* 初始化种群 */
        if (initialise) {
            /* 初始化种群中的个体 */
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

    /* 获取种群中指定索引的个体 */
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    /* 获取种群中适应度最高的个体 */
    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    /* 得到种群的个数 */
    public int size() {
        return individuals.length;
    }

    // 重置种群中指定索引的个体
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }

    /* 输出种群中的个体 */
    public void displayPopulation(){
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.getIndividual(i).toString());
        }
    }
}

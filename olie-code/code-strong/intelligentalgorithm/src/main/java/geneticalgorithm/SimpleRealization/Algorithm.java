package geneticalgorithm.SimpleRealization;

/**
 * Created by niexianglin on 2016/9/23 9:47
 * Class Description:
 */
public class Algorithm {
    /* 交叉概率 */
    private static final double uniformRate = 0.5;
    /* 突变概率 */
    private static final double mutationRate = 0.015;
    /* 交叉操作时，遴选的个体数目:选择 */
    private static final int tournamentSize = 5;
    /* 精英主义 */
    private static final boolean elitism = true;


    // 种群进化
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);

        // 保存最优的个体
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        // 设置种群交叉开始索引：最优个体不参与交叉变异
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }

        // 种群交叉，交叉之前需要进行选择操作。
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            Individual newIndiv = crossover(indiv1, indiv2);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // 种群变异
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    // 个体交叉
    private static Individual crossover(Individual indiv1, Individual indiv2) {
        Individual newSol = new Individual();
        for (int i = 0; i < indiv1.size(); i++) {
            //交换基因
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        return newSol;
    }

    // 个体变异
    private static void mutate(Individual indiv) {
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    // 选择：每次选择指定数目的个体进行交叉
    private static Individual tournamentSelection(Population pop) {
        // 创建一个临时的群体
        Population tournament = new Population(tournamentSize, false);
        // 随机设置临时种群的个体
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        // 得到临时种群中适应度最高的个体
        Individual fittest = tournament.getFittest();
        return fittest;
    }
}

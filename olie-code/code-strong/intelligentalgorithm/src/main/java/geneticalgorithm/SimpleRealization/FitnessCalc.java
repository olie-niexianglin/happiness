package geneticalgorithm.SimpleRealization;

/*
    计算个体适应度类：通常这个类需要重新定义，因为它就是我们要解决问题的缩影，
                      通过设定一个合适的适应度公式，可以确定染色体交叉、变异的方向，也就是目标问题的求解方向。
 */
public class FitnessCalc {
    static byte[] solution = new byte[64];

    // 设定一个候选解
    public static void setSolution(byte[] newSolution) {
        solution = newSolution;
    }

    // 如果需要，可以利用该方法设置一个初始解
    static void setSolution(String newSolution) {
        solution = new byte[newSolution.length()];
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);
            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
    }

    // 通过与候选解比较，计算每个个体的适应度
    static int getFitness(Individual individual) {
        int fitness = 0;
        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                fitness++;
            }
        }
        return fitness;
    }

    // 获取个体适可以达到的最高适应度
    static int getMaxFitness() {
        int maxFitness = solution.length;
        return maxFitness;
    }
}

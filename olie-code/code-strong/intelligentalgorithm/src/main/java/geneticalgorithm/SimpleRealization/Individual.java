package geneticalgorithm.SimpleRealization;

/*
    个体类，包含：
                gense[index]:是一个基因
                gense[defaultGeneLength]:是一个染色体
 */
public class Individual {
    static int defaultGeneLength = 64;
    private byte[] genes = new byte[defaultGeneLength];
    // Cache
    private int fitness = 0;

    // 初始化一个个体的染色体
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    //如果有需要：可用使用该方法设置染色体的长度
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }
    //获取染色体指定索引的基因
    public byte getGene(int index) {
        return genes[index];
    }
    //设置染色体指定索引的基因
    public void setGene(int index, byte value) {
        genes[index] = value;
        fitness = 0;
    }

    //获取染色体中基因的个数
    public int size() {
        return genes.length;
    }

    //计算个体染色体的适应度
    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}

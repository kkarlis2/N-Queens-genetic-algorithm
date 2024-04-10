import java.util.Random;

public class Chromosome implements Comparable<Chromosome>
{
    //Each position shows the vertical position of a queen in the corresponding column
    private int[] genes;

    //Integer that holds the fitness score of the chromosome
    private int fitness;

    //Constructs a randomly created chromosome
    Chromosome(int n)
    {
        this.genes = new int[n];
        Random r = new Random();
        for(int i = 0; i < this.genes.length; i++)
        {
            this.genes[i] = r.nextInt(n);
        }
        this.calculateFitness();
    }

    //Constructs a copy of a chromosome
    Chromosome(int[] genes,int n)
    {
        this.genes = new int[n];
        for(int i = 0; i < this.genes.length; i++)
        {
            this.genes[i] = genes[i];
        }
        this.calculateFitness();
    }

    //Calculates the fitness score of the chromosome as the number queen pairs that are NOT threatened
    //The maximum number of queen pairs that are NOT threatened is (n-1) + (n-2) + ... + (n-n) = 7 + 6 + 5 + 4 + 3 + 2 + 1 = 2n
    void calculateFitness()
    {
        int nonThreats = 0;
        for(int i = 0; i < this.genes.length; i++)
        {
            for(int j = i+1; j < this.genes.length; j++)
            {
                if((this.genes[i] != this.genes[j]) &&
                        (Math.abs(i - j) != Math.abs(this.genes[i] - this.genes[j])))
                {
                    nonThreats++;
                }
            }
        }
        this.fitness = nonThreats;
    }

    //Mutate by randomly changing the position of a queen
    void mutate(int n)
    {
        Random r = new Random();
        this.genes[r.nextInt(n)] = r.nextInt(n);
        this.calculateFitness();
    }

    public int[] getGenes() {
        return this.genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public int getFitness() {
        return this.fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    void print()
    {
        System.out.print("Chromosome : |");
        for(int i = 0; i < this.genes.length; i++)
        {
            System.out.print(this.genes[i]);
            System.out.print("|");
        }
        System.out.print(", Fitness : ");
        System.out.println(this.fitness);

        System.out.println("------------------------------------");
        for(int i = 0; i < this.genes.length; i++)
        {
            for(int j=0; j < this.genes.length; j++)
            {
                if(this.genes[j] == i)
                {
                    System.out.print("|Q");
                }
                else
                {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
        System.out.println("------------------------------------");
    }

    //compareTo function -> sorting can be done according to fitness scores
    @Override
    public int compareTo(Chromosome x)
    {
        return this.fitness - x.fitness;
    }
}

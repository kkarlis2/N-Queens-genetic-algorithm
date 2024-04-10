import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
		System.out.println("----------------N-queens puzzle problem -----------------------");
		System.out.println("\nGive the number of queens(N)");
		Scanner myObj = new Scanner(System.in);
		int queens;
		while (true){
			queens=myObj.nextInt();
			if (queens<=2){
				System.out.println("Give a bigger number of Queens");
				continue;
			}
			break;
        }
		long start = System.currentTimeMillis();
		GeneticAlgorithm algorithm = new GeneticAlgorithm();
        //populationSize, mutationProbability, maximumSteps, minimumFitness
        Chromosome solution = algorithm.run(1000, 0.08, 1000, 28,queens);
        solution.print();
		long end = System.currentTimeMillis();
		System.out.println("Search time: "+(double)(end-start)/1000+" sec.");
    }
}

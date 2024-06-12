package project_CAMPO_MINADO;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] tabuleiro = new char[5][5];
		char[][] tabuleiro2 = new char[5][5];
		Random random = new Random();

		int numMinas = 3;
		int minasColocadas = 0;

		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
				tabuleiro[i][j] = '1';
				tabuleiro2[i][j] = 'x';
			}
		}

		while (minasColocadas < numMinas) {
			int linha = random.nextInt(tabuleiro.length);
			int coluna = random.nextInt(tabuleiro.length);
			if (tabuleiro[linha][coluna] != '*') {
				tabuleiro[linha][coluna] = '*';
				minasColocadas++;
			}

		}

		for (int i = 0; i < tabuleiro2.length; i++) {
			for (int j = 0; j < tabuleiro2[i].length; j++) {
				System.out.print(tabuleiro2[i][j] + " ");
				if (j == 4) {
					System.out.print("\n");
				}
			}
		}
		System.out.println();
		System.out.println("===CAMPO MINADO===");
		System.out.println("Tente não se explodir!!");
		System.out.println();
		System.out.print("Escolha a linha (0 a 4): ");
		int lin = sc.nextInt();
		System.out.print("Escolha a coluna (0 a 4: ");
		int col = sc.nextInt();

		if (tabuleiro[lin][col] == '*') {
			System.out.println("Você explodiu!! ");
			for (int i = 0; i < tabuleiro.length; i++) {
				for (int j = 0; j < tabuleiro[i].length; j++) {
					System.out.print(tabuleiro[i][j] + " ");
					if (j == 4) {
						System.out.print("\n");
					}
				}
			}
		} else {
			for (int i = 0; i < tabuleiro2.length; i++) {
				for (int j = 0; j < tabuleiro2[i].length; j++) {
					tabuleiro2[lin][col] = tabuleiro[lin][col];
					System.out.print(tabuleiro2[i][j] + " ");
					if (j == 4) {
						System.out.print("\n");
					}
				}
			}
			while (tabuleiro[lin][col] != '*') {
				System.out.print("Escolha a linha (0 a 4): ");
				lin = sc.nextInt();
				System.out.print("Escolha a coluna (0 a 4: ");
				col = sc.nextInt();
				for (int i = 0; i < tabuleiro2.length; i++) {
					for (int j = 0; j < tabuleiro2[i].length; j++) {
						tabuleiro2[lin][col] = tabuleiro[lin][col];
						System.out.print(tabuleiro2[i][j] + " ");
						if (j == 4) {
							System.out.print("\n");
						}
					}
				}
			}
			if (tabuleiro[lin][col] == '*') {
				System.out.println("Você explodiu!! ");
				for (int i = 0; i < tabuleiro.length; i++) {
					for (int j = 0; j < tabuleiro[i].length; j++) {
						System.out.print(tabuleiro[i][j] + " ");
						if (j == 4) {
							System.out.print("\n");
						}
					}
				}
			}
		}

		sc.close();

	}

}

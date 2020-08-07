package com.game.name;

import java.util.Random;
import java.util.Scanner;

public class Game {
	static int FireTimes;
	static int Restart;
	static int RevolverType;
	static int RoundCount;
	static int RoundsTotal;
	static int RoundsInChambers;
	static int[] Chamber = new int[8];

	public static void main(String[] args) {
		System.out.println("Russian Roulette.");
		System.out.println("By MincerafterJack");
		System.out.println("CC BY-NC-SA 3.0");
		System.out.println("This is a Beta version, it may have some serious problems.");
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println();
			while (true) {
				System.out.println();
				System.out.println("Which revolver would you like?");
				System.out.println("	1- Taulus 905   (5 rounds)");
				System.out.println("	2- Webley Mk.IV (6 rounds)");
				System.out.println("	3- Nagant M1895 (7 rounds)");
				System.out.println("	4- M327-TRR8    (8 rounds)");
				if (scan.hasNextInt()) {
					RevolverType = scan.nextInt();
				}
				if (RevolverType < 1 | RevolverType > 4) {
					System.out.println("Invalid number!");
					System.out.println();
				} else {
					break;
				}
			}
			;
			while (true) {
				System.out.println();
				System.out.println("How many rounds would you like to load?");
				if (scan.hasNextInt()) {
					RoundsTotal = scan.nextInt();
				}
				if (RoundsTotal < 1 | RoundsTotal >= RevolverType + 4) {
					System.out.println("Invalid number!");
					System.out.println();
				} else {
					break;
				}
			}
			;
			System.out.println();
			System.out.println("Loading the revolver, please wait...");
			while (true) {
				RoundCount = RevolverType + 3;
				for (int i = 0; i <= RoundCount;) {
					Chamber[i] = new Random().nextInt(2);
					RoundsInChambers += Chamber[i];
					i += 1;
					if (RoundsInChambers == RoundsTotal) {
						break;
					}
				}
				break;
			}
			while (true) {
				if (FireTimes == RevolverType + 4 - RoundsTotal) {
					System.out.println("Congratulations! You win!");
					break;
				}
				System.out.println();
				System.out.println("Now, Fire or Rotate?");
				System.out.println("	0- Fire");
				System.out.println("	1- Rotate");
				if (scan.hasNextInt()) {
					int Choice = scan.nextInt();
					if (Choice == 0) {
						FireTimes = FireTimes + 1;
						if (Chamber[RoundCount] == 1) {
							System.out.println("Bam! Game over!");
							System.out.println();
							break;
						} else {
							System.out.println("Phew! Nothing happens.");
							System.out.println();
							RoundCount -= 1;
							if (RoundCount < 0) {
								RoundCount = RevolverType + 3;
							}
						}
					}
					if (Choice == 1) {
						RoundCount = new Random().nextInt(RevolverType + 4);
						System.out.println("Rotated.");
					}
					if (Choice != 0 & Choice != 1) {
						System.out.println("Invalid choice!");
					}
				}
			}
			System.out.println();
			System.out.println("0- Exit");
			if (scan.hasNextInt()) {
				if (scan.nextInt() == 0) {
					break;
				}
			}
		}
		scan.close();
	}
}

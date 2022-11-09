package minesweeper;

import java.util.Scanner;
import java.util.Random;

public class Minesweeper {

	public static void main(String[] args) {

		Random aleatorio = new Random();
		Scanner input = new Scanner(System.in);

		int campo[][] = new int[32][17];
		char mapa[][] = new char[32][17];
		char numchar[][] = new char[32][17];
		char coluna, recomecar = '2', opcoes, dificuldade = '2';
		int i, j, bombas, x, linha = 420, colunaint = 100, y, z = 0, linhabomba, ex = 0, boom, ri, rj, qtbombas, I, J,
				ti = 22, tj = 12, qb = 60, nb;
		String linhachar, l;

		while (recomecar == '2') {

			y = 0;

			System.out.println("\t\t\t\t\tMINESWEEPER\n\n1. Jogar\n2. Opções\n3. Como jogar\n4. Sair do jogo");

			while (y == 0) {
				recomecar = input.next().charAt(0);
				if (recomecar != '1' && recomecar != '2' && recomecar != '3' && recomecar != '4') {
					y--;
				}
				y++;
			}
			y = 0;
			if (recomecar == '4') {
				break;
			}
			if (recomecar == '2') {

				opcoes = '0';

				while (opcoes != '3') {

					opcoes = '0';

					System.out.println("1. Tamanho do campo\n2. Dificuldade \n3. Menu");

					while (opcoes != '2' && opcoes != '1' && opcoes != '3') {
						opcoes = input.next().charAt(0);
						if (opcoes != '2' && opcoes != '1' && opcoes != '3') {
							System.out.println(
									"Digite \"1\" para selecionar o tamanho do campo, \"2\" para selecionar a dificuldade ou \"3\" para retornar ao menu principal.");
						}
					}
					if (opcoes == '1') {
						opcoes = '0';
						System.out.println("Tamanho do campo\n1. Pequeno (10x5)\n2. Médio (20x10)\n3. Grande(30x15)");
						while (opcoes != '2' && opcoes != '1' && opcoes != '3') {
							opcoes = input.next().charAt(0);
							if (opcoes != '2' && opcoes != '1' && opcoes != '3') {
								System.out.println(
										"O tamanho \"" + recomecar + "\" não existe, selecione um tmanho existente.");
							}
						}
						if (opcoes == '1') {
							ti = 12;
							tj = 7;
						}
						if (opcoes == '2') {
							ti = 22;
							tj = 12;
						}
						if (opcoes == '3') {
							ti = 32;
							tj = 17;
						}
						opcoes = '0';
					}
					if (opcoes == '2') {
						opcoes = '0';
						dificuldade = '0';
						System.out.println("Dificuldade\n1. Fácil\n2. Médio\n3. Difícil");
						while (dificuldade != '2' && dificuldade != '1' && dificuldade != '3') {
							dificuldade = input.next().charAt(0);
							if (dificuldade != '2' && dificuldade != '1' && dificuldade != '3') {
								System.out.println("A dificuldade \"" + dificuldade
										+ "\" nâo existe, selecione uma dificuldade existente.");
							}
						}
					}
					if (dificuldade == '1') {
						if (ti == 12) {
							qb = 10;
						}
						if (ti == 22) {
							qb = 40;
						}
						if (ti == 32) {
							qb = 90;
						}
					}
					if (dificuldade == '2') {
						if (ti == 12) {
							qb = 15;
						}
						if (ti == 22) {
							qb = 60;
						}
						if (ti == 32) {
							qb = 135;
						}
					}
					if (dificuldade == '3') {
						if (ti == 12) {
							qb = 22;
						}
						if (ti == 22) {
							qb = 90;
						}
						if (ti == 32) {
							qb = 200;
						}
					}
				}
			}
			if (recomecar == '3') {
				System.out.println(
						"\t\t\t\t\tMINESWEEPER\n\nO jogo consiste em encontrar todas as posiçôes sem bombas no mapa.\nPara revelar uma posiçâo no mapa, basta "
								+ "informar a linha e coluna desejadas no mapa.\nPara selecionar uma linha, digite o número da linha indicado no mapa.\nPara selecionar a coluna,"
								+ " digite a letra da coluna indicada no mapa.\nCaso a linha digitada seja \"0\", o jogador poderá marcar a posição de uma bomba, independentemente\n"
								+ "se há ou não uma bomba ali.\nApós o jogador selecionar a linha e coluna desejada, um número aparecerá no local escolhido,\nrepresentando"
								+ " a quantidade de bombas ao redor daquela casa.\nCaso a letra \"B\" apareça no lugar de um número, significa que o jogador encontrou uma bomba.\n"
								+ "Se o jogador econtrar uma bomba, o jogo se encerrará. Dando ao jogador a opção de recomecar,\nvoltar ao menu ou encerrar o jogo.\nÉ possível selecionar"
								+ " o tamanho do mapa e a dificuldade do jogo escolhendo dificuldade no menu\nentrando em \"opções\".\n\n");
				while (recomecar != '2') {
					System.out.println("Digite \"2\" para voltar ao menu.");
					recomecar = input.next().charAt(0);
				}
			}

			while (recomecar == '1') {

				qtbombas = 0;
				boom = 0;
				linhabomba = 100;
				y = 0;

				for (i = 1; i < ti - 1; i++) {
					if (i == 1) {
						if (ti == 22) {
							System.out.println("\t\t\t\t\tMINESWEEPER\n\n" + qb + " A B C D E F G H I J");
						}
						if (ti == 12) {
							System.out.println("\t\t\t\t\tMINESWEEPER\n\n" + qb + " A B C D E");
						}
						if (ti == 32) {
							System.out.println("\t\t\t\t\tMINESWEEPER\n\n" + qb + " A B C D E F G H I J K L M N O");
						}
					}
					if (qb > 99) {
						System.out.print(" ");
					}
					if (i < 10) {
						System.out.print("0");
					}
					System.out.print((i) + "|");
					for (j = 1; j < tj - 1; j++) {
						mapa[i][j] = ' ';
						System.out.print(mapa[i][j] + "|");
					}
					System.out.println("");
				}
				System.out.print("Insira a linha e coluna desejada.\nLinha:");

				while (y == 0) {

					linhachar = input.next();

					if (linhachar.charAt(0) == '0' || linhachar.charAt(0) == '1' || linhachar.charAt(0) == '2'
							|| linhachar.charAt(0) == '3' || linhachar.charAt(0) == '4'
							|| linhachar.charAt(0) == '5' || linhachar.charAt(0) == '6' || linhachar.charAt(0) == '7'
							|| linhachar.charAt(0) == '8' || linhachar.charAt(0) == '9') {
						linha = Integer.parseInt(linhachar);
					}

					if (linha > ti - 2) {
						System.out
								.print("A linha (" + linhachar + ") não existe, escolha uma linha existente.\nLinha:");
						y--;
					}
					y++;
				}
				y = 0;
				if (linha < 1) {
					System.out.print("Indique a posição da bomba.\nLinha:");
					while (y == 0) {
						l = input.next();
						if (l.charAt(0) == '0' || l.charAt(0) == '1' || l.charAt(0) == '2' || l.charAt(0) == '3'
								|| l.charAt(0) == '4' || l.charAt(0) == '5' ||
								l.charAt(0) == '6' || l.charAt(0) == '7' || l.charAt(0) == '8' || l.charAt(0) == '9') {
							linhabomba = Integer.parseInt(l);
						}
						if (linhabomba > ti - 2) {
							System.out.print("A linha (" + l + ") não existe, escolha uma linha existente.\nLinha:");
							y--;
						}
						y++;
					}
				}
				y = 0;

				while (y == 0) {
					System.out.print("Coluna:");

					coluna = input.next().charAt(0);

					if (coluna == 'a' || coluna == 'A') {
						colunaint = 1;
					}
					if (coluna == 'b' || coluna == 'B') {
						colunaint = 2;
					}
					if (coluna == 'c' || coluna == 'C') {
						colunaint = 3;
					}
					if (coluna == 'd' || coluna == 'D') {
						colunaint = 4;
					}
					if (coluna == 'e' || coluna == 'E') {
						colunaint = 5;
					}
					if (coluna == 'f' || coluna == 'F') {
						colunaint = 6;
					}
					if (coluna == 'g' || coluna == 'G') {
						colunaint = 7;
					}
					if (coluna == 'h' || coluna == 'H') {
						colunaint = 8;
					}
					if (coluna == 'i' || coluna == 'I') {
						colunaint = 9;
					}
					if (coluna == 'j' || coluna == 'J') {
						colunaint = 10;
					}
					if (coluna == 'k' || coluna == 'K') {
						colunaint = 11;
					}
					if (coluna == 'l' || coluna == 'L') {
						colunaint = 12;
					}
					if (coluna == 'm' || coluna == 'M') {
						colunaint = 13;
					}
					if (coluna == 'n' || coluna == 'N') {
						colunaint = 14;
					}
					if (coluna == 'o' || coluna == 'O') {
						colunaint = 15;
					}
					if (colunaint > tj - 2) {
						System.out.print("A coluna (" + coluna + ") não existe, escolha uma coluna existente.");
						y--;
					}
					y++;
				}
				y = 0;
				for (i = 0; i < ti; i++) {
					// System.out.print("|");
					for (j = 0; j < tj; j++) {
						campo[i][j] = 0;
						// System.out.print(campo[i][j] + "|");
					}
					// System.out.println("");
				}
				for (bombas = 0; bombas < qb; bombas++) {
					x = 0;
					while (x == 0) {
						i = aleatorio.nextInt(ti - 2) + 1;
						j = aleatorio.nextInt(tj - 2) + 1;

						if (campo[i][j] != 0) {
							x--;
						}
						campo[i][j] = 9;
						x++;
					}
					if (linhabomba == 100) {
						for (i = linha - 1; i <= linha + 1; i++) {
							for (j = colunaint - 1; j <= colunaint + 1; j++) {
								if (campo[i][j] == 9) {
									bombas--;
									campo[i][j] = 0;
								}
							}
						}
					}
				}

				/* System.out.println("");

				for (i = 0; i < ti; i++) {
					// System.out.print("|");
					for (j = 0; j < tj; j++) {
						// System.out.print(campo[i][j] + "|");
					}
					// System.out.println("");
				}
				// System.out.println("");*/

				for (i = 1; i < ti - 1; i++) {
					for (j = 1; j < tj - 1; j++) {
						if (campo[i][j] >= 9) {
							campo[i + 1][j]++;
							campo[i + 1][j - 1]++;
							campo[i + 1][j + 1]++;
							campo[i - 1][j]++;
							campo[i - 1][j - 1]++;
							campo[i - 1][j + 1]++;
							campo[i][j - 1]++;
							campo[i][j + 1]++;
							qtbombas++;
						}
					}
				}
				for (i = 0; i < ti; i++) {
					for (j = 0; j < tj; j++) {
						if (i == 0 || i == ti - 1 || j == 0 || j == tj - 1) {
							campo[i][j]++;
							if (campo[i][j] >= 9) {
								campo[i][j] = 5;
							}
						}
					}
				}

				for (i = 1; i < ti - 1; i++) {
					// if(i==1) {
					// System.out.println(60 + " A B C D E F G H I J");
					// }
					// if(i<10) {
					// System.out.print("0");
					// }
					// System.out.print(i + "|");
					for (j = 1; j < tj - 1; j++) {
						if (campo[i][j] > 9) {
							campo[i][j] = 9;
						}
						// System.out.print(campo[i][j] + "|");
					}
					// System.out.println("");
				}
				// System.out.println("");

				for (i = 0; i < ti; i++) {

					for (j = 0; j < tj; j++) {
						if (campo[i][j] == 0) {
							numchar[i][j] = '0';
						}
						if (campo[i][j] == 1) {
							numchar[i][j] = '1';
						}
						if (campo[i][j] == 2) {
							numchar[i][j] = '2';
						}
						if (campo[i][j] == 3) {
							numchar[i][j] = '3';
						}
						if (campo[i][j] == 4) {
							numchar[i][j] = '4';
						}
						if (campo[i][j] == 5) {
							numchar[i][j] = '5';
						}
						if (campo[i][j] == 6) {
							numchar[i][j] = '6';
						}
						if (campo[i][j] == 7) {
							numchar[i][j] = '7';
						}
						if (campo[i][j] == 8) {
							numchar[i][j] = '8';
						}
						if (campo[i][j] == 9) {
							numchar[i][j] = 'B';
						}
					}
				}
				nb = (ti - 2) * (tj - 2) - qb;
				while (z < nb) {

					z = 0;
					y = 0;

					if (linha == 420) {
						System.out.print("Insira a linha e coluna desejada.\nLinha:");

						while (y == 0) {

							linhachar = input.next();

							if (linhachar.charAt(0) == '0' || linhachar.charAt(0) == '1' || linhachar.charAt(0) == '2'
									|| linhachar.charAt(0) == '3' || linhachar.charAt(0) == '4'
									|| linhachar.charAt(0) == '5' || linhachar.charAt(0) == '6'
									|| linhachar.charAt(0) == '7' || linhachar.charAt(0) == '8'
									|| linhachar.charAt(0) == '9') {
								linha = Integer.parseInt(linhachar);
							}

							if (linha > ti - 2) {
								System.out.print(
										"A linha (" + linhachar + ") não existe, escolha uma linha existente.\nLinha:");
								y--;
							}
							y++;
						}
						y = 0;
						if (linha < 1) {
							System.out.print("Indique a posição da bomba.\nLinha:");
							while (y == 0) {
								l = input.next();
								if (l.charAt(0) == '0' || l.charAt(0) == '1' || l.charAt(0) == '2' || l.charAt(0) == '3'
										|| l.charAt(0) == '4' || l.charAt(0) == '5' ||
										l.charAt(0) == '6' || l.charAt(0) == '7' || l.charAt(0) == '8'
										|| l.charAt(0) == '9') {
									linhabomba = Integer.parseInt(l);
								}
								if (linhabomba > ti - 2) {
									System.out.print(
											"A linha (" + l + ") não existe, escolha uma linha existente.\nLinha:");
									y--;
								}
								y++;
							}
						}
						y = 0;

						while (y == 0) {
							System.out.print("Coluna:");

							coluna = input.next().charAt(0);

							if (coluna == 'a' || coluna == 'A') {
								colunaint = 1;
							}
							if (coluna == 'b' || coluna == 'B') {
								colunaint = 2;
							}
							if (coluna == 'c' || coluna == 'C') {
								colunaint = 3;
							}
							if (coluna == 'd' || coluna == 'D') {
								colunaint = 4;
							}
							if (coluna == 'e' || coluna == 'E') {
								colunaint = 5;
							}
							if (coluna == 'f' || coluna == 'F') {
								colunaint = 6;
							}
							if (coluna == 'g' || coluna == 'G') {
								colunaint = 7;
							}
							if (coluna == 'h' || coluna == 'H') {
								colunaint = 8;
							}
							if (coluna == 'i' || coluna == 'I') {
								colunaint = 9;
							}
							if (coluna == 'j' || coluna == 'J') {
								colunaint = 10;
							}
							if (coluna == 'k' || coluna == 'K') {
								colunaint = 11;
							}
							if (coluna == 'l' || coluna == 'L') {
								colunaint = 12;
							}
							if (coluna == 'm' || coluna == 'M') {
								colunaint = 13;
							}
							if (coluna == 'n' || coluna == 'N') {
								colunaint = 14;
							}
							if (coluna == 'o' || coluna == 'O') {
								colunaint = 15;
							}
							if (colunaint > tj - 2) {
								System.out.print("A coluna (" + coluna + ") não existe, escolha uma coluna existente.");
								y--;
							}
							y++;
						}
					}
					y = 0;

					if (linhabomba == 100) {

						if (mapa[linha][colunaint] != ' ' && mapa[linha][colunaint] != 'X') {
							for (i = linha - 1; i <= linha + 1; i++) {
								for (j = colunaint - 1; j <= colunaint + 1; j++) {
									if (mapa[i][j] == 'X') {
										ex++;
									}
								}
							}
						}
						if (mapa[linha][colunaint] != ' ' && mapa[linha][colunaint] != 'X' && ex == 0) {
						}
						if (ex == campo[linha][colunaint]) {
							for (i = linha - 1; i <= linha + 1; i++) {
								for (j = colunaint - 1; j <= colunaint + 1; j++) {
									if (mapa[i][j] == ' ') {
										mapa[i][j] = numchar[i][j];
										if (mapa[i][j] == 'B') {
											boom++;
										}
									}
								}
							}
						}
						if (mapa[linha][colunaint] == ' ') {
							mapa[linha][colunaint] = numchar[linha][colunaint];
						}

						for (I = linha - 1; I <= linha + 1; I++) {
							for (J = colunaint - 1; J <= colunaint + 1; J++) {
								if (mapa[I][J] == '0') {
									campo[I][J] = 100;
									while (y <= 0) {
										for (i = 1; i <= ti - 1; i++) {
											for (j = 1; j <= tj - 1; j++) {
												if (campo[i][j] == 100) {
													for (ri = i - 1; ri <= i + 1; ri++) {
														for (rj = j - 1; rj <= j + 1; rj++) {
															if (campo[ri][rj] == 0) {
																campo[ri][rj] = 100;
																y--;
															}
														}
													}
												}
											}
										}
										y++;
									}
									for (i = 1; i <= ti - 1; i++) {
										for (j = 1; j <= tj - 1; j++) {
											if (campo[i][j] == 100) {
												for (ri = i - 1; ri <= i + 1; ri++) {
													for (rj = j - 1; rj <= j + 1; rj++) {
														mapa[ri][rj] = numchar[ri][rj];
													}
												}
											}
										}
									}
								}
							}
						}
						y = 0;

						System.out.println("");
						for (i = 1; i < ti - 1; i++) {
							if (i == 1) {
								if (qtbombas < 10) {
									System.out.print("0");
								}
								if (ti == 22) {
									System.out.println(qtbombas + " A B C D E F G H I J");
								}
								if (ti == 12) {
									System.out.println(qtbombas + " A B C D E");
								}
								if (ti == 32) {
									System.out.println(qtbombas + " A B C D E F G H I J K L M N O");
								}
							}
							if (qtbombas > 99) {
								System.out.print(" ");
							}
							if (i < 10) {
								System.out.print("0");
							}
							System.out.print((i) + "|");
							for (j = 1; j < tj - 1; j++) {
								System.out.print(mapa[i][j] + "|");
							}
							System.out.println("");
						}
						if (mapa[linha][colunaint] == 'B') {
							boom++;
						}
						if (boom > 0) {
							System.out.println("\nBOOM! Você ativou uma bomba.");
							break;
						}
					}
					if (linhabomba != 100) {
						if (mapa[linhabomba][colunaint] == ' ') {
							mapa[linhabomba][colunaint] = 'X';
							qtbombas--;
							y++;
						}
						if (y == 0) {
							if (mapa[linhabomba][colunaint] == 'X') {
								mapa[linhabomba][colunaint] = ' ';
								qtbombas++;
							}
						}
						y = 0;
						for (i = 1; i < ti - 1; i++) {
							if (i == 1) {
								if (qtbombas < 10) {
									System.out.print("0");
								}
								if (ti == 22) {
									System.out.println(qtbombas + " A B C D E F G H I J");
								}
								if (ti == 12) {
									System.out.println(qtbombas + " A B C D E");
								}
								if (ti == 32) {
									System.out.println(qtbombas + " A B C D E F G H I J K L M N O");
								}
							}
							if (qtbombas > 99) {
								System.out.print(" ");
							}
							if (i < 10) {
								System.out.print("0");
							}
							System.out.print((i) + "|");
							for (j = 1; j < tj - 1; j++) {
								System.out.print(mapa[i][j] + "|");
							}
							System.out.println("");
						}
					}
					for (i = 1; i <= ti - 1; i++) {
						for (j = 1; j <= tj - 1; j++) {
							if (mapa[i][j] != ' ' && mapa[i][j] != 'X') {
								z++;
							}
						}
					}

					if (ti == 12) {
						z = z - 16;
					}
					if (ti == 22) {
						z = z - 31;
					}
					if (ti == 32) {
						z = z - 46;
					}

					// System.out.println(z);

					linhabomba = 100;
					linha = 420;
					colunaint = 100;
					ex = 0;
				}

				if (z == nb) {
					System.out.println(
							"\nParab�ns! Você completou o campo minado e provou que é incrível! \\o/ \\o/ \\o/\n");
				}

				System.out.println("\n1. Jogar novamente\n2. Menu inicial \n3. Encerrar o jogo");

				while (y == 0) {
					recomecar = input.next().charAt(0);
					if (recomecar != '1' && recomecar != '2' && recomecar != '3') {
						System.out.println(
								"Insira \"1\" para jogar novamente, \"2\" para retornar ao menu ou \"3\" para encerrar o jogo.");
						y--;
					}
					y++;
				}
			}
		}
	}
}

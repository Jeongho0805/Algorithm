package past._23년백준풀이._23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12100
 */
public class Easy2048_골드2 {

    static int n;
    static int[][] map;
    static String[] orders = {"U", "D", "L", "R"};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        moveLeft(map);
//        for (int[] ints : map) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }

        List<List<String>> orderList = new ArrayList<>();
        createOrders(orderList, new ArrayList<>());

        int answer = 0;
        for (List<String> order : orderList) {
            answer = Math.max(answer, getMaxBlock(order));
        }
        System.out.println(answer);
    }

    private static int getMaxBlock(List<String> order) {
        int[][] copyMap = makeCopyMap();

//        for (int[] ints : copyMap) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }

        for (String o : order) {
            if (o.equals("U")) {
                moveUp(copyMap);
            }
            else if (o.equals("D")) {
                moveDown(copyMap);
            }
            else if (o.equals("L")) {
                moveLeft(copyMap);
            }
            else {
                moveRight(copyMap);
            }
        }
        return findMaxBlock(copyMap);
    }

    private static void moveUp(int[][] copyMap) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int value = copyMap[j][i];
                if (value == 0) {
                    int idx = j+1;
                    while (idx < n) {
                        if (copyMap[idx][i] != 0) {
                            copyMap[j][i] = copyMap[idx][i];
                            copyMap[idx][i] = 0;
                            j--;
                            break;
                        }
                        idx++;
                    }
                }
                else if (j+1 < n) {
                    if (value == copyMap[j+1][i]) {
                        copyMap[j][i] = value * 2;
                        copyMap[j+1][i] = 0;
                    }
                    else if (copyMap[j+1][i] == 0) {
                        int idx = j+2;
                        int nextValue = -1;
                        while (idx < n) {
                            if (copyMap[idx][i] != 0) {
                                nextValue = copyMap[idx][i];
                                copyMap[idx][i] = 0;
                                break;
                            }
                            idx++;
                        }
                        if (nextValue != -1) {
                            if (value == nextValue) {
                                copyMap[j][i] = value * 2;
                                copyMap[j+1][i] = 0;
                            } else {
                                copyMap[j+1][i] = nextValue;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void moveDown(int[][] copyMap) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                int value = copyMap[j][i];
                if (value == 0) {
                    int idx = j - 1;
                    while (idx >= 0) {
                        if (copyMap[idx][i] != 0) {
                            copyMap[j][i] = copyMap[idx][i];
                            copyMap[idx][i] = 0;
                            j++;
                            break;
                        }
                        idx--;
                    }
                } else if (j - 1 >= 0) {
                    if (value == copyMap[j - 1][i]) {
                        copyMap[j][i] = value * 2;
                        copyMap[j - 1][i] = 0;
                    } else if (copyMap[j - 1][i] == 0) {
                        int idx = j - 2;
                        int nextValue = -1;
                        while (idx >= 0) {
                            if (copyMap[idx][i] != 0) {
                                nextValue = copyMap[idx][i];
                                copyMap[idx][i] = 0;
                                break;
                            }
                            idx--;
                        }
                        if (nextValue != -1) {
                            if (value == nextValue) {
                                copyMap[j][i] = value * 2;
                                copyMap[j - 1][i] = 0;
                            } else {
                                copyMap[j - 1][i] = nextValue;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void moveRight(int[][] copyMap) {
        for (int i=0; i<n; i++) {
            for (int j=n-1; j>=0; j--) {
                int value = copyMap[i][j];
                if (value == 0) {
                    int idx = j-1;
                    while (idx >= 0) {
                        if (copyMap[i][idx] != 0) {
                            copyMap[i][j] = copyMap[i][idx];
                            copyMap[i][idx] = 0;
                            j++;
                            break;
                        }
                        idx--;
                    }
                }
                else if (j-1 >= 0) {
                    if (value == copyMap[i][j-1]) {
                        copyMap[i][j] = value * 2;
                        copyMap[i][j-1] = 0;
                    }
                    else if (copyMap[i][j-1] == 0) {
                        int idx = j-2;
                        int nextValue = -1;
                        while (idx >= 0) {
                            if (copyMap[i][idx] != 0) {
                                nextValue = copyMap[i][idx];
                                copyMap[i][idx] = 0;
                                break;
                            }
                            idx--;
                        }
                        if (nextValue != -1) {
                            if (value == nextValue) {
                                copyMap[i][j] = value * 2;
                                copyMap[i][j-1] = 0;
                            } else {
                                copyMap[i][j-1] = nextValue;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void moveLeft(int[][] copyMap) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int value = copyMap[i][j];
                if (value == 0) {
                    int idx = j+1;
                    while (idx < n) {
                        if (copyMap[i][idx] != 0) {
                            copyMap[i][j] = copyMap[i][idx];
                            copyMap[i][idx] = 0;
                            j--;
                            break;
                        }
                        idx++;
                    }
                }
                else if (j+1 < n) {
                    if (value == copyMap[i][j+1]) {
                        copyMap[i][j] = value * 2;
                        copyMap[i][j+1] = 0;
                    }
                    else if (copyMap[i][j+1] == 0) {
                        int idx = j+2;
                        int nextValue = -1;
                        while (idx < n) {
                            if (copyMap[i][idx] != 0) {
                                nextValue = copyMap[i][idx];
                                copyMap[i][idx] = 0;
                                break;
                            }
                            idx++;
                        }
                        if (nextValue != -1) {
                            if (value == nextValue) {
                                copyMap[i][j] = value * 2;
                                copyMap[i][j+1] = 0;
                            } else {
                                copyMap[i][j+1] = nextValue;
                            }
                        }
                    }
                }
            }
        }
    }

    private static int findMaxBlock(int[][] copyMap) {
        int result = 0;
        for (int i=0; i<copyMap.length; i++) {
            for (int j=0; j<copyMap[0].length; j++) {
                result = Math.max(copyMap[i][j], result);
            }
        }
        return result;
    }

    private static int[][] makeCopyMap() {
        int[][] copyMap = new int[map.length][map[0].length];
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }

    private static void createOrders(List<List<String>> orderList, ArrayList<String> temp) {
        if (temp.size() == 5) {
            orderList.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0; i<4; i++) {
            temp.add(orders[i]);
            createOrders(orderList, temp);
            temp.remove(temp.size()-1);
        }
    }
}

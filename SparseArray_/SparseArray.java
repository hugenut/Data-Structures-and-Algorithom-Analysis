package SparseArray_;

/**
 * @author 何蛋
 * @version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建二维数组 11*11
        //0:表示没有棋子，1表示黑子，2表示白子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][7] = 1;

        //输出原始二维数组
        //使用增强型 for循环
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //二维数组转稀疏数组思路：
        //1.遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);

        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];

        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0数据放入稀疏数组中
        int count = 0; //用count记录这是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("稀疏数组为如下形式：-----------");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            System.out.println();
        }
        System.out.println();

        //将稀疏数组 恢复成 原始的二维数组
        //1.先读取稀疏数组的第一行，创建原始数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2.再读取稀疏数组后几行的数据，并付给原始的二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组------------");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}

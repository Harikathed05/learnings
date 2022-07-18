package com.company;


/**
 * There are a row of N houses, each house can be painted with one of the three colors: red, blue or green.
 *
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a N x 3 cost matrix A.
 *
 * For example, A[0][0] is the cost of painting house 0 with color red; A[1][2] is the cost of painting house 1 with color green, and so on.
 *
 * Find the minimum total cost to paint all houses.
 *  A = [  [1, 2, 3]
 *         [10, 11, 12]
 *      ]
 *      output =  12
 *
 */
public class PaintHouse {

    int [] minCostArray = new int[]{0,0,0};

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3}, {10, 11, 12}, {7, 8, 9}
        };
        int[][] A1 = {
                {468, 335, 501},
                {170, 725, 479},
                {359, 963, 465},
                {706, 146, 282},
                {828, 962, 492},
                {996, 943, 828},
                {437, 392, 605},
                {903, 154, 293},
                {383, 422, 717},
                {719, 896, 448},
                {727, 772, 539},
                {870, 913, 668},
                {300, 36, 895},
                {704, 812, 323},
                {334, 674, 665},
                {142, 712, 254},
                {869, 548, 645},
                {663, 758, 38},
                {860, 724, 742},
                {530, 779, 317},
                {36, 191, 843},
                {289, 107, 41},
                {943, 265, 649},
                {447, 806, 891},
                {730, 371, 351},
                {7, 102, 394},
                {549, 630, 624},
                {85, 955, 757},
                {841, 967, 377},
                {932, 309, 945},
                {440, 627, 324},
                {538, 539, 119},
                {83, 930, 542},
                {834, 116, 640},
                {659, 705, 931},
                {978, 307, 674},
                {387, 22, 746},
                {925, 73, 271},
                {830, 778, 574},
                {98, 513, 987},
                {291, 162, 637},
                {356, 768, 656},
                {575, 32, 53},
                {351, 151, 942},
                {725, 967, 431},
                {108, 192, 8},
                {338, 458, 288},
                {754, 384, 946},
                {910, 210, 759},
                {222, 589, 423},
                {947, 507, 31}
        };
        PaintHouse paintHouse = new PaintHouse();
        //System.out.println(paintHouse.minimumCost(A));
        System.out.println(paintHouse.minimumCost(A1));
    }


    private int minValueIndex(int[] a, int index) {
        int minCostIndex = 0;
        if (index == 0) {
            if (a[1] < a[2]) {
                minCostIndex = 1;
                return minCostIndex;
            } else {
                minCostIndex = 2;
                return minCostIndex;
            }
        } else if (index == 1) {
            if (a[0] < a[2]) {
                minCostIndex = 0;
                return minCostIndex;
            } else {
                minCostIndex = 2;
                return minCostIndex;
            }
        } else if (index == 2) {
            if (a[0] < a[1]) {
                minCostIndex = 0;
                return minCostIndex;
            } else {
                minCostIndex = 1;
                return minCostIndex;
            }
        }
        return minCostIndex;
    }

    private int minInThree(int[] a) {
        int temp = a[0];
        if (a[1] < a[2]) {
            if (temp > a[1]) {
                temp = a[1];
            }
        } else {
            if (temp > a[2]) {
                temp = a[2];
            }
        }
        return temp;
    }

    public int minimumCost(int[][] A) {
        minCostArray = A[0];
        for (int i = 1; i < A.length ; i++) {
            int [] minCostArrayForNewRow = new int[]{0,0,0};
            for(int j = 0; j < 3; j++) {
                minCostArrayForNewRow[j] = A[i][j] + minCostArray[minValueIndex(minCostArray, j)];
            }
            minCostArray = minCostArrayForNewRow;
        }
        return minInThree(minCostArray);
    }
}

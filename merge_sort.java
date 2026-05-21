package lab3;


import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;


public class merge_sort {

	    static void merge(int arr[],
	                      int l,
	                      int m,
	                      int r) {

	        int n1 = m - l + 1;
	        int n2 = r - m;

	        int L[] = new int[n1];
	        int R[] = new int[n2];

	        for (int i = 0; i < n1; i++) {
	            L[i] = arr[l + i];
	        }

	        for (int j = 0; j < n2; j++) {
	            R[j] = arr[m + 1 + j];
	        }

	        int i = 0;
	        int j = 0;
	        int k = l;

	        while (i < n1 && j < n2) {

	            if (L[i] <= R[j]) {

	                arr[k] = L[i];
	                i++;
	            }
	            else {

	                arr[k] = R[j];
	                j++;
	            }

	            k++;
	        }

	        while (i < n1) {

	            arr[k] = L[i];
	            i++;
	            k++;
	        }

	        while (j < n2) {

	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }

	    static void mergeSort(int arr[],
	                          int l,
	                          int r) {

	        if (l < r) {

	            int m = (l + r) / 2;

	            mergeSort(arr, l, m);

	            mergeSort(arr, m + 1, r);

	            merge(arr, l, m, r);
	        }
	    }

	    public static void main(String[] args) {

	        int nValues[] = {
	                5000,
	                10000,
	                15000,
	                20000,
	                25000
	        };

	        Random random = new Random();

	        DefaultCategoryDataset dataset =
	                new DefaultCategoryDataset();

	        for (int n : nValues) {

	            int arr[] = new int[n];

	            for (int i = 0; i < n; i++) {

	                arr[i] =
	                        random.nextInt(100000);
	            }

	            long start =
	                    System.nanoTime();

	            mergeSort(arr, 0, n - 1);

	            long end =
	                    System.nanoTime();

	            double time =
	                    (end - start) / 1000000.0;

	            System.out.println(
	                    "Elements : " + n +
	                    " Time : " +
	                    time + " ms");

	            dataset.addValue(
	                    time,
	                    "Merge Sort",
	                    String.valueOf(n));
	        }

	        JFreeChart chart =
	                ChartFactory.createLineChart(
	                        "Merge Sort Time Complexity",
	                        "Number of Elements",
	                        "Time in Milliseconds",
	                        dataset,
	                        PlotOrientation.VERTICAL,
	                        true,
	                        true,
	                        false
	                );

	        ChartPanel panel =
	                new ChartPanel(chart);

	        JFrame frame =
	                new JFrame(
	                        "Merge Sort Graph");

	        frame.setContentPane(panel);

	        frame.setSize(800, 600);

	        frame.setDefaultCloseOperation(
	                JFrame.EXIT_ON_CLOSE);

	        frame.setVisible(true);
	    }
	}
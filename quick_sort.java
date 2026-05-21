package lab3;

import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class quick_sort {

	static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String args[]) {

        int nValues[] = {5000, 10000, 15000, 20000, 25000};

        Random r = new Random();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int n : nValues) {

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = r.nextInt(100000);
            }

            long start = System.nanoTime();

            quickSort(arr, 0, n - 1);

            long end = System.nanoTime();

            double time = (end - start) / 1000000.0;

            System.out.println(
                    "Elements : " + n +
                    " Time Taken : " +
                    time + " ms");

            dataset.addValue(
                    time,
                    "Time",
                    String.valueOf(n));
        }

        JFreeChart chart =
                ChartFactory.createLineChart(
                        "Quick Sort Time Complexity",
                        "Number of Elements",
                        "Time in ms",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false);

        ChartFrame frame =
                new ChartFrame(
                        "Quick Sort Graph",
                        chart);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
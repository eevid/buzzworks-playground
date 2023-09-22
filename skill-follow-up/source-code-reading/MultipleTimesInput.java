import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class MultipleTimesInput {

    public static void main(String args[]) {

        final int REPEAT_TIMES = 10;
        final int INPUT_DATA_MAX_LENGTH = 30;

        List<Integer> locations = null;
        var inputAndLocations = new LinkedHashMap<String, List<Integer>>();

        try (var scanner = new Scanner(System.in)) {

            String input = null;
            int count = 1;

            while (count <= REPEAT_TIMES) {

                System.out.print(count + "回目の値を入力してください。 ： ");
                input = scanner.nextLine();

                if (input.isEmpty() || input == null || input.length() > INPUT_DATA_MAX_LENGTH) {

                    System.out.println("1文字以上" + INPUT_DATA_MAX_LENGTH + "文字以下で値を入力してください。");
                    continue;
                }

                locations = inputAndLocations.getOrDefault(input, new ArrayList<Integer>());
                locations.add(count);
                inputAndLocations.put(input, locations);

                count++;
            }
        } catch (Exception e) {

            System.err.println("不具合が発生しました。処理を中断します。");
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("【結果】");

        for (String input : inputAndLocations.keySet()) {

            locations = inputAndLocations.get(input);

            if (locations.size() >= 2) {

                System.out.print(input + ":[");
                System.out.print(locations.stream().map(String::valueOf).collect(Collectors.joining(",")));
                System.out.println("]");
            }
        }
    }
}

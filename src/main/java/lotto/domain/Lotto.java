package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicationCheck(numbers);
        numberRangeCheck(numbers);
        this.numbers = numbers;
    }

    private static List<Integer> sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 수로 이루어져 있습니다.");
        }
        return numbers;
    }

    private static List<Integer> numberRangeCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45까지 입니다.");
            }
        }
        return numbers;
    }

    private static List<Integer> duplicationCheck(List<Integer> numbers) {
        Set<Integer> duplicationTestSet = new HashSet<>(numbers);
        if (duplicationTestSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 입력 하신 번호중 중복이 있습니다.");
        }
        return numbers;
    }

    public static List<List<Integer>> makeLottos(Integer money) {
        List<List<Integer>> lottos = new ArrayList<>();
        System.out.printf("%s개를 구매했습니다.\n", (money / 1000));
        for (int ticket = 0; ticket < money / 1000; ticket++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            lottos.add(lotto);
            lotto = new ArrayList<>();
        }
        return lottos;
    }

    public static void printLotto(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }


}

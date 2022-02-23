package nb993.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoUtil {
    public static final int COUNT_OF_LOTTO_NUM = 6;
    public static void validate(List<Integer> lottoNumbers) {
        validateCountOfNumbers(lottoNumbers);
        validateTicketRange(lottoNumbers);
        validateDuplicate(lottoNumbers);
    }

    public static void validate(List<Integer> lottoNumbers, int bonusNumber) {
        validate(lottoNumbers);
        validateRange(bonusNumber);
        List<Integer> wholeNumbers = new ArrayList<Integer>(lottoNumbers);
        wholeNumbers.add(bonusNumber);
        validateDuplicate(wholeNumbers);
    }

    private static void validateCountOfNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUM) {
            throw new IllegalArgumentException("로또 번호의 갯수는 " + COUNT_OF_LOTTO_NUM + "개여야 합니다.");
        }
    }

    private static void validateTicketRange(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            validateRange(number);
        }
    }

    private static void validateRange(int lottoNumber) {
        if (lottoNumber < 1 || 45 < lottoNumber) {
            throw new IllegalArgumentException("로또 번호는 1~45의 값을 입력해주세요.");
        }
    }

    private static void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> numSet = new HashSet<Integer>(lottoNumbers);
        if (numSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }
}

package henrotaym.env.mappers;

import java.util.Optional;
import java.util.function.Function;

public class OptionalMapper {

    public static <T, R> Optional<R> mapOptional(Optional<T> optional, Function<T, R> mapper) {
        return optional.map(mapper);
    }
}

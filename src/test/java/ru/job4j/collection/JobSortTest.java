package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobSortTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
        cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByName() {
        int rsl = new JobDescByName().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
        rsl = new JobDescByName().compare(
                new Job("Fix bug", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
        rsl = new JobDescByName().compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenComparatorByPriority() {
        int rsl = new JobDescByPriority().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
        rsl = new JobDescByPriority().compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isLessThan(0);
        rsl = new JobDescByName().compare(
                new Job("Impl task", 0),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isEqualTo(0);
    }
}
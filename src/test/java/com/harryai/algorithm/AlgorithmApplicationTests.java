package com.harryai.algorithm;

import com.harryai.algorithm.utlis.DataPrepareUtil;
import com.harryai.algorithm.utlis.RandomUtil;
import org.junit.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AlgorithmApplicationTests {
    private static Integer[] data = DataPrepareUtil.prepareNumberData(200000, RandomUtil.prepareInt(9));

    @Test
    public void test() throws InterruptedException {
        User one = new User(1);
        User two = new User(2);
        User third = new User(3);
        DelayQueue<Delayed> delayeds = new DelayQueue<>();
        delayeds.put(one);
        delayeds.put(two);
        delayeds.put(third);
        System.out.println(delayeds);
        System.out.println(delayeds.take());
        System.out.println(delayeds.take());
        System.out.println(delayeds.take());
//        while (!delayeds.isEmpty()) {
//            System.out.println(delayeds.take());
//        }


    }

    class User implements Delayed {
        int id;
        long delay;

        public User(int id) {
            this.id = id;
            delay=TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + id;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    '}';
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long overtime = delay - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            return unit.convert(overtime, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            User other = (User) o;
            if (id > other.getId()) return 1;
            if (id < other.getId()) return -1;
            return 0;
        }
    }

}

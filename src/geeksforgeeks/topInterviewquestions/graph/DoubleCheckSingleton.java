package geeksforgeeks.topInterviewquestions.graph;

/**
 * Created by v-dsindhi on 12/16/15.
 */
public class DoubleCheckSingleton {

        private int f; //instance field
        private static DoubleCheckSingleton instance = null;
        private DoubleCheckSingleton () {
            this.f = 10;
        }
        public static DoubleCheckSingleton getInstance() {
            if (instance == null) {
                //1st check for lazy initialization
                synchronized (DoubleCheckSingleton.class) {
                    if (instance == null) {
                        //2nd check for lazy initialization
                        instance = new DoubleCheckSingleton ();
                    }
                }
            }
            return instance;
        }
    }

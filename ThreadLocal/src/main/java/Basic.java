public class Basic {

    //ThreadLocal<T>
    public static ThreadLocal<Long> x=new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            System.out.println("Initial Value run..");
            return Thread.currentThread().getId();
        }
    };

    public static void main(String[] args) {
        System.out.println("main方法线程");
        new Thread(){
            @Override
            public void run() {
                System.out.println("新建线程");
                System.out.println(x.get());
            }
        }.start();
        x.set(100L);
        x.remove();
        System.out.println(x.get());
    }
}

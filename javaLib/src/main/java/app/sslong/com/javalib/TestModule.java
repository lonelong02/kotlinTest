package app.sslong.com.javalib;

public class TestModule {





    public  static void main(String[] argrs){

        final Thread t1 = new Thread(){
             @Override
             public void run() {
                 super.run();
                 try {
                     System.out.println("t1 前");
                     Thread.sleep(2000);
                     System.out.println("t1 后");
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         };
         Thread t2 = new Thread(){
             @Override
             public void run() {
                 try {
                     super.run();
                     System.out.println("t2 前");
                     t1.start();
                     System.out.println("join 前");
                     t1.join();
                     System.out.println("join 后");
                     System.out.println("t2 后");
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         };
         t2.start();


    }
}

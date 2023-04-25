class MyThread extends Thread{
@Override
public void run(){
for (int i=1;i<=5 ;i++ ){
System.out.println("child thread");

}
}
}
public class tryout{
public static void main(String... args){
MyThread t= new MyThread();
t.setPriority(7);//line -1
t.start();
for (int i=1; i<=5; i++){
System.out.println("main thread");
}
}
}

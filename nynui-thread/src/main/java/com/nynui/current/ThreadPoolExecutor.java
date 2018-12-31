package com.nynui.current;

import javax.annotation.security.RunAs;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author : nynui
 * @Description
 * @Data: Create  in  15:55 2018/10/31
 * @ Modified By :
 */
public class ThreadPoolExecutor  implements Executors {

/**
  * @Author: nynui
  * @Description:
  * @Date: 15:57 2018/10/31
  * @Version: 最小线程值
  * @Params:  * @param null
  */

    private Integer  minPoolSize;
    /***
     * 最大线程值
     */
    private Integer maxPoolSize;
    /**
     * 线程队列
     */
    private BlockingQueue<Runnable> queue;

    public ThreadPoolExecutor(Integer minPoolSize, Integer maxPoolSize, LinkedBlockingDeque<Runnable> queue) {
        this.minPoolSize = minPoolSize;
        this.maxPoolSize = maxPoolSize;
        this.queue = queue;
    }


    /**
      * @Author: nynui
      * @Description:
      * @Date: 15:55 2018/10/31
      * @Version:
      * @Params:  * @param null
      */
    @Override
    public void Executors(Runnable runnable) {
        addWorker(runnable);
    }

    private void addWorker(Runnable task){
        Worker w=   new Worker(task);
        w.thread.start();
    }



    class  Worker  implements Runnable{
      private Runnable work;

      private Thread  thread;

        public Worker(Runnable work) {
            this.work = work;
            thread=new Thread(this);
        }

        @Override
        public void run() {
            task(this);
    }



    private void task(Runnable task){

    }
    }
}

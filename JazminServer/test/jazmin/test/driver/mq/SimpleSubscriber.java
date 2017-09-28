/**
 * 
 */
package jazmin.test.driver.mq;

import jazmin.driver.mq.MessageEvent;
import jazmin.driver.mq.TopicSubscriberDefine;
import jazmin.util.RandomUtil;

/**
 * @author yama
 *
 */
public class SimpleSubscriber {
	//
	@TopicSubscriberDefine(topic="test1",name=2)
	public void test1(MessageEvent e){
		System.err.println("test1:"+e.message.id+"--"+e.message.delieverTimes+"-");
		if(RandomUtil.randomInt(5)==1){
			e.messageQueueDriver.reject("test1",e.message.id);
		}else{
			e.messageQueueDriver.accept("test1",e.message.id);
		}
		
	}
	
	/*@TopicSubscriberDefine(topic="test1",name=2)
	public void reject(MessageEvent e){
		System.err.println("test11:"+e.message.delieverTimes+"-"+e.message.payload);
		if(e.message.delieverTimes>5){
			e.messageQueueDriver.accept("test1",e.message.id);
		}else{
			e.messageQueueDriver.reject("test1",e.message.id);
		}
	}*/
	
}
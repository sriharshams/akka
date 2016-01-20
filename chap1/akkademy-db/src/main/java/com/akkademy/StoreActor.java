package com.akkademy;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import com.akkademy.messages.Notes;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sms on 1/20/2016.
 */
public class StoreActor  extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final List<String> notesMessageList = new ArrayList<String>();
    private StoreActor(){
        receive(ReceiveBuilder.match(Notes.class, message -> {
            log.info("Received notes message – message {} ", message.getMessage());
            notesMessageList.add(message.getMessage()); }).matchAny(o -> log.info("received unknown message {}", o)).build());
    }
}
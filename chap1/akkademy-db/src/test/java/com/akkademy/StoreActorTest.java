package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.akkademy.messages.Notes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sms on 1/20/2016.
 */
public class StoreActorTest {
    ActorSystem system = ActorSystem.create();
    @Test
    public void itShouldSendNotesToList() {
        TestActorRef<StoreActor> actorRef = TestActorRef.create(system, Props.create(StoreActor.class));
        actorRef.tell(new Notes("Test"), ActorRef.noSender());
        actorRef.tell(new Notes("Test2"), ActorRef.noSender());
        StoreActor storeActor = actorRef.underlyingActor();
        assertEquals(storeActor.notesMessageList.get(0), "Test");
        assertEquals(storeActor.notesMessageList.get(1), "Test2");}

}

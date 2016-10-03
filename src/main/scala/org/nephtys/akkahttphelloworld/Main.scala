package org.nephtys.akkahttphelloworld

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server._
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.{Directives, Route}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller

/**
  * Created by nephtys on 10/3/16.
  */
object Main extends App{
  println("This ia a console output from akka-http-hello-world")

  implicit val actorSystem = ActorSystem("system")
  implicit val actorMaterializer = ActorMaterializer()

  val route : Route = pathSingleSlash {
      get {
        complete {
          "Hello world from akka-http-hello-world"
        }
      }
    }

  Http().bindAndHandle(route,"localhost",9123)
}

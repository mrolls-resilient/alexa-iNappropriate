package io.igu.whatson

import com.amazonaws.services.lambda.runtime.Context
import com.typesafe.scalalogging.LazyLogging
import io.circe.Json
import io.github.mkotsur.aws.handler.Lambda
import io.github.mkotsur.aws.handler.Lambda._
import io.igu.meetup.v2.ConciergeClientComponent
import io.igu.whatson.model.AlexaResponse


class WhatsOnLambda extends Lambda[Json, AlexaResponse] with WhatsOnLambdaComponent with ConciergeClientComponent {
  val conciergeClient: ConciergeClient = new ConciergeClient {}
}

trait WhatsOnLambdaComponent extends LazyLogging {
  self: Lambda[Json, AlexaResponse] with ConciergeClientComponent =>

  override def handle(call: Json, context: Context): Either[Throwable, AlexaResponse] = {
    logger.info("Received alexa call with payload: {}", call)

    ???
  }
}
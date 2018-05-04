package io.igu.whatson.model

import io.circe.generic.semiauto._
import io.circe.{Decoder, Encoder}

case class AlexaRequest() {

}

object AlexaRequest {
  implicit val encoder: Encoder[AlexaRequest] = deriveEncoder[AlexaRequest]
  implicit val decoder: Decoder[AlexaRequest] = deriveDecoder[AlexaRequest]
}

package io.igu.whatson.model

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

case class AlexaResponse() {

}

object AlexaResponse {

  implicit val encoder: Encoder[AlexaResponse] = deriveEncoder[AlexaResponse]
  implicit val decoder: Decoder[AlexaResponse] = deriveDecoder[AlexaResponse]
}

package io.igu.meetup.v2.model

import io.circe.generic.semiauto._
import io.circe.{Decoder, Encoder}

case class MeetupResponse[T](results: T, meta: Metadata) {

}

object MeetupResponse {
  implicit def encoder[T : Encoder]: Encoder[MeetupResponse[T]] = deriveEncoder[MeetupResponse[T]]
  implicit def decoder[T : Decoder]: Decoder[MeetupResponse[T]] = deriveDecoder[MeetupResponse[T]]

}
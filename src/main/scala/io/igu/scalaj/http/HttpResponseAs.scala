package io.igu.scalaj.http

import io.circe.{Decoder, Error, parser}
import scalaj.http.HttpResponse

trait HttpResponseAs {

  implicit class As(httpResponse: HttpResponse[String]) {
    def as[U: Decoder]: HttpResponse[U] = parser.decode[U](httpResponse.body) match {
      case Left(error: Error) => throw new RuntimeException("Error while decoding", error)
      case Right(value)       => httpResponse.copy(body = value)
    }
  }

}

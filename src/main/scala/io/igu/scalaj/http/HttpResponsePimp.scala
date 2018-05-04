package io.igu.scalaj.http

import scalaj.http.HttpResponse

trait HttpResponsePimp extends HttpResponseMap with HttpResponseAs {


}

object HttpResponsePimp extends HttpResponsePimp {


}
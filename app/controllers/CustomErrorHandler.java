package controllers;

import javax.inject.Inject;
import javax.inject.Provider;

import play.Configuration;
import play.Environment;
import play.api.OptionalSourceMapper;
import play.api.UsefulException;
import play.api.routing.Router;
import play.http.DefaultHttpErrorHandler;
import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import play.mvc.Results;
import views.html.errors.notfound;
import views.html.errors.badrequest;

public class CustomErrorHandler extends DefaultHttpErrorHandler {

  @Inject
  public CustomErrorHandler(Configuration configuration, Environment environment,
      OptionalSourceMapper sourceMapper, Provider<Router> routes) {
    super(configuration, environment, sourceMapper, routes);
    System.out.println("CustomErrorHandler constructor");
  }


  @Override
  protected Promise<Result> onNotFound(RequestHeader request, String exception) {
    System.out.println("onNotFound");
    return Promise.<Result>pure(
      Results.notFound(notfound.render("ページがみつかりません", exception, 404))
    );
  }

  @Override
  protected Promise<Result> onBadRequest(RequestHeader request, String exception) {
    System.out.println("onBadRequest");
    return Promise.<Result>pure(
      Results.badRequest(badrequest.render("不正なリクエストです", exception, 400))
    );
  }

  @Override
  protected Promise<Result> onDevServerError(RequestHeader request, UsefulException exception) {
    System.out.println("onDevServerError");
    return Promise.<Result>pure(
      Results.internalServerError("DEV: A server error occurred: " + exception.getMessage())
    );
  }

  @Override
  protected Promise<Result> onProdServerError(RequestHeader request, UsefulException exception) {
    System.out.println("onProdServerError");
    return Promise.<Result>pure(
      Results.internalServerError("PROD: A server error occurred: " + exception.getMessage())
    );
  }

}

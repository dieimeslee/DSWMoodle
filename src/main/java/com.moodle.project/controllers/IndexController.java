package com.moodle.project.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import javax.inject.Inject;
import org.apache.log4j.Logger;

@Controller
public class IndexController {

  final static Logger logger = Logger.getLogger(IndexController.class);

  private final Result result;

  protected IndexController() {
    this(null);
  }

  @Inject
  public IndexController(Result result) {
    this.result = result;
  }

  @Get("/")
  public void index() {
    result.include("mensagem", "Funciona");
  }
}

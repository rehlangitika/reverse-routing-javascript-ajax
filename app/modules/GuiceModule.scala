package modules

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import play.api.{Configuration, Environment}
import services.{CacheUserService, UserService}

/**
  * Created by gitika on 10/3/17.
  */
class GuiceModule(environment: Environment, configuration: Configuration ) extends AbstractModule {

  def configure() = {

    bind(classOf[UserService])
      .annotatedWith(Names.named("cache"))
      .to(classOf[CacheUserService]).asEagerSingleton()
  }
}

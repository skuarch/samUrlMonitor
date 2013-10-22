<%-- 
    Document   : login
    Created on : Aug 1, 2013, 5:39:15 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="/pages/application/metas.jsp" />        
        <s:include value="/pages/application/header.jsp" />                
    </head>
    <body onload="loadWebSocket(wsUrlAlarms)">

        <div class="navbar navbar-inverse navbar-fixed-top bs-docs-nav">
            <div class="container">
                <a href="#" class="navbar-brand">
                    <s:property value="getText('application.brand')" />
                </a>
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="nav-collapse collapse bs-navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#">

                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="container">

            <div class="row">

                <div class="col-lg-6 col-offset-3">

                    <div class="panel panel-primary">

                        <div class="panel-heading">
                            <strong>
                                <s:property value="getText('login.panel.form.title')" />
                            </strong>
                        </div>                       

                        <form action="authentication" method="POST" enctype="application/x-www-form-urlencoded">
                            <fieldset>
                                <legend>
                                    <s:property value="getText('login.form.title')"/>
                                </legend>
                                <div class="form-group">
                                    <label for="username">                                        
                                        <s:property value="getText('login.form.user.name')"/>
                                    </label>
                                    <input type="text" class="form-control" name="username" id="username" placeholder="<s:property value="getText('login.form.user.name.placeholder')"/>" tabindex="1">
                                </div>
                                <div class="form-group">
                                    <label for="password">
                                        <s:property value="getText('login.form.user.password')"/>
                                    </label>
                                    <input type="password" class="form-control" name="password" id="password" placeholder="<s:property value="getText('login.form.user.password.placeholder')"/>" tabindex="2">
                                </div>                                
                                <button type="reset" class="btn btn-block" tabindex="4">
                                    <s:property value="getText('login.form.button.clear')"/>
                                </button>
                                <button type="submit" class="btn btn-block btn-success" tabindex="3">
                                    <s:property value="getText('login.form.button.submit')"/>
                                </button>
                                
                                <br/>
                                
                                <div class="text-danger">
                                    <s:property value="message" />
                                </div>
                                
                            </fieldset>
                        </form>

                        <ul class="list-group list-group-flush text-right">
                            <li class="list-group-item">
                                <h6>
                                    <s:property value="getText('login.form.footer')"/>
                                </h6>
                            </li>
                        </ul>
                    </div>                   

                </div>

            </div>

        </div>

    </body>
</html>

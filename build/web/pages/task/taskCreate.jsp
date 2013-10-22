<%-- 
    Document   : taskCreate
    Created on : Aug 6, 2013, 10:28:40 AM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="/pages/application/metas.jsp" />
        <s:include value="/pages/application/header.jsp" />
    </head>
    <body>

        <s:include value="/pages/application/navigation.jsp" /> 

        <div class='container'>
            <div class='row'>
                <div class="col-lg-8 col-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <s:property value="getText('task.form.create.title')" />
                        </div>                       

                        <form action="" name="taskForm" id="taskForm" method="POST" enctype="application/x-www-form-urlencoded">
                            <fieldset>
                                <legend>
                                    <s:property value="getText('task.form.create.legend')"/>
                                </legend>
                                <div class="form-group">
                                    <label for="name">                                        
                                        <s:property value="getText('task.form.create.name')"/>
                                    </label>
                                    <input type="text" class="form-control" name="name" id="url" placeholder="<s:property value="getText('task.form.create.name.placeholder')"/>" tabindex="1">
                                </div>
                                <div class="form-group">
                                    <label for="urls">
                                        <s:property value="getText('task.form.create.url')"/>
                                    </label>
                                    <input type="text" class="form-control" name="urls" id="urls" placeholder="<s:property value="getText('task.form.create.url.placeholder')"/>" tabindex="2">
                                </div>
                                <div class="form-group">
                                    <label for="trigger">
                                        <s:property value="getText('task.form.create.trigger')"/>
                                    </label>
                                    <input type="text" class="form-control" name="trigger" id="trigger" placeholder="<s:property value="getText('task.form.create.trigger.placeholder')"/>" tabindex="3">
                                </div>
                                <div class="form-group">
                                    <label for="period">
                                        <s:property value="getText('task.form.create.period')"/>
                                    </label>
                                    <input type="text" class="form-control" name="period" id="period" placeholder="<s:property value="getText('task.form.create.period.placeholder')"/>" tabindex="4">
                                </div>
                                <div class="form-group">
                                    <label for="timeout">
                                        <s:property value="getText('task.form.create.timeout')"/>
                                    </label>
                                    <input type="text" class="form-control" name="timeout" id="timeout" placeholder="<s:property value="getText('task.form.create.timeout.placeholder')"/>" tabindex="5">
                                </div>
                                <div class="form-group">
                                    <label for="email">
                                        <s:property value="getText('task.form.create.notification.email')"/>
                                    </label>                                    
                                    <input type="text" class="form-control" name="email" id="email" placeholder="<s:property value="getText('task.form.create.notification.email.placeholder')"/>" tabindex="5">
                                </div>
                                <div class="form-group">
                                    <label for="sms">
                                        <s:property value="getText('task.form.create.notification.sms')"/>
                                    </label>                                    
                                    <input type="text" class="form-control" name="sms" id="sms" placeholder="<s:property value="getText('task.form.create.notification.sms.placeholder')"/>" tabindex="5">
                                </div>
                                <div class="form-group">
                                    <label for="method">
                                        <s:property value="getText('task.form.create.method')"/>
                                    </label>
                                    <select name="method" id="method" class="btn-block" tabindex="6">
                                        <option value="GET">GET</option>
                                        <option value="POST">POST</option>                                        
                                    </select>
                                </div>                                
                                <button type="reset" class="btn btn-block" tabindex="8">
                                    <s:property value="getText('login.form.button.clear')"/>
                                </button>
                                <button type="button" class="btn btn-block btn-success" tabindex="7" onclick="createTask();">
                                    <s:property value="getText('task.form.button.create')"/>
                                </button>

                                <br/>

                                <div class="text-danger">
                                    <s:property value="message" />
                                </div>

                            </fieldset>
                        </form>

                    </div>
                </div>
            </div>

            <s:include value="/pages/application/footer.jsp" />
        </div>
    </body>
</html>

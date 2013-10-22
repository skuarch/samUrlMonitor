<%-- 
    Document   : taskScheduler
    Created on : Aug 5, 2013, 7:14:46 PM
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
    <body onload="taskTable()">

        <s:include value="/pages/application/navigation.jsp" />

        <div class="container">
            <h1><s:property value="getText('task.title')"/></h1>
            <hr>            
            
            <div class="row">

                <div class="col-lg-8">                    

                    <div id="taskTableDiv">
                        
                    </div>

                </div>
                
                <div class="col-lg-4">
                    
                    <div class="panel">
                    
                        <div class="panel-heading">
                            <s:property value="getText('task.options')"/>
                        </div>
                        
                        <input onclick="location.href='taskCreate'" class="btn btn-primary btn-block" value="create task"/>
                        
                    </div>
                    
                </div>

            </div>

            <s:include value="/pages/application/footer.jsp" />
        </div>        

    </body>
</html>

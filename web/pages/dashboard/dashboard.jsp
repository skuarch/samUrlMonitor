<%-- 
    Document   : dashboard
    Created on : Aug 5, 2013, 6:31:17 PM
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

        <div class="container">
            <h1><s:property value="getText('dashboard.title')" /></h1>
            <hr>

            <s:if test="alarms.size < 1">
                <div class="alert alert-info">
                    <s:property value="getText('dashboard.no.alarms')" />                    
                </div>
            </s:if>
            <s:else>

                <table class="footable">
                    <thead>
                        <tr>
                            <th>
                                <s:property value="getText('dashboard.table.th.1')" />
                            </th>
                            <th>
                                <s:property value="getText('dashboard.table.th.2')" />
                            </th>
                            <th>
                                <s:property value="getText('dashboard.table.th.3')" />
                            </th>
                            <th data-hide="phone,tablet">
                                <s:property value="getText('dashboard.table.th.4')" />
                            </th>
                            <th data-hide="phone,tablet">
                                <s:property value="getText('dashboard.table.th.5')" />
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="alarms" var="a">
                            <tr <s:if test="#a.level == 3"> class="alert alert-danger" </s:if><s:elseif test="#a.level == 1">class="alert alert-success"</s:elseif> >
                                <td>
                                    <s:property value="#a.level"/>
                                </td>
                                <td>
                                    <s:property value="#a.taskName"/>
                                </td>
                                <td>
                                    <s:property value="#a.date"/>
                                </td>
                                <td>
                                    <s:property value="#a.description"/>
                                </td>
                                <td>
                                    <s:property value="#a.url"/>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>

                </table>
            </s:else>

            <s:include value="/pages/application/footer.jsp" />
        </div>               

    </body>
</html>

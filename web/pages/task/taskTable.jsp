<%@taglib prefix="s" uri="/struts-tags" %>

<s:if test="tasks.size < 1">
    <div class="alert alert-info">
        <s:property value="getText('task.no')"/>
    </div>
</s:if>
<s:else>
    <table class="footable">
        <thead>
            <tr>
                <th>
                    Status
                </th>
                <th>
                    ID
                </th>
                <th>
                    Task Name
                </th>
                <th>
                    URL
                </th>
                <th>
                    Method
                </th>
                <th data-hide="phone,tablet">
                    Trigger
                </th>                
                <th data-hide="phone,tablet">
                    Period
                </th>
                <th data-hide="phone,tablet">
                    Option
                </th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="tasks" var="t">
                <tr>
                    <td>                        
                        <div style="height: 16px; width: 16px; margin: auto">

                            <s:if test="#t.status == 1">
                                <img src="img/ok.png"/>
                            </s:if>
                            <s:else>
                                <img src="img/denied.png"/>
                            </s:else>
                        </div>                        
                    </td>                    
                    <td>
                        <s:property value="#t.id"/>
                    </td>
                    <td>
                        <s:property value="#t.name"/>
                    </td>
                    <td>
                        <s:property value="#t.url"/>
                    </td>
                    <td>
                        <s:property value="#t.method"/>
                    </td>
                    <td>
                        <s:property value="#t.trigger"/> 
                    </td>
                    <td>
                        <s:property value="#t.period"/> 
                    </td>
                    <td>
                        <!--<input type="button" value="edit" class="btn btn-primary" />-->
                        <input type="button" onclick="deleteTask(<s:property value="#t.id"/>);" value="delete" class="btn btn-danger" />
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</s:else>





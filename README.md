## Function List

- Start Process Instance (return : ProcessInstanceVar)

    
        String processDefinitionKey
        Map<String , Object> processInstanceVariables
        
        
- Claim Task (void function)

            String taskId
            String userName
            
- Un Claim Task (void function)

            String taskId
           
- Get All Task(Group) (return List<Task>)

            String currentUserGroups

- Get All Task(Current User) (return List<Task>)

            String currentUserName
- Complete Task (void function)
   
           String taskId
           
- Complete Task(ProcessVariables)
        
        String taskId;
        Map<String,Object> variables
        

- Get Process Name(return String )
    
        String processInstanceId

- Get Active Task (return List<Task>)
        
        String processInstanceId
        
- Get Process Instance(return processInstanceId)
        
        String processInstanceId
        
        
- Get Process Instance Variables(return Map<String , Object>)
        
        String processInstanceId
        
- Set Process Instance Variable(void function)
        
        String processInstanceId
        String key
        String value

- Delete Process Instance (void function)
        
        String processInstanceId
        
- Delete Complete Process Instance(void function)

        String processInstanceId
        String key
        String value


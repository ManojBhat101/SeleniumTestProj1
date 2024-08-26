pipeline 
{
    agent any

    stages 
    {
        stage('Build') 
        {
            steps 
            {
                echo 'Building the Application'
            }
        }
        stage('Test') 
        {
            steps 
            {
                echo 'Testing the Application'
            }
        }
        stage('Deploy') 
        {
            steps 
            {
                echo 'Deploying the Application'
            }
        }
    }
    post
    {
        always
        {
            emailext attachLog: true, body: 'Summary of Jenkins Pipeline', subject: 'Pipeline Status', to: 'shivamshakti555@gmail.com'
        }
    }
}

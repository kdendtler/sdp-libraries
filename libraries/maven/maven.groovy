package maven

void call(){

}

void run(String goals) {
    node {
        stage("Maven") {
            withMaven(maven: 'maven') {
                if (goals) {
                    sh "mvn " + goals
                }
            }
        }
    }
}
pipeline {
  agent any
  stages {
    stage('检出') {
      steps {
        checkout([$class: 'GitSCM',
        branches: [[name: env.GIT_BUILD_REF]],
        userRemoteConfigs: [[
          url: env.GIT_REPO_URL,
          credentialsId: env.CREDENTIALS_ID
        ]]])
      }
    }
    stage('编译') {
      steps {
        dir("${env.DOCKER_BUILD_CONTEXT}") {
          sh "mvn clean package -P ${env.RUNNING_ENV} -Dmaven.test.skip=true"
        }
      }
    }
    stage('构建 Docker 镜像') {
      steps {
        sh "mv Dockerfile ./${env.DOCKER_BUILD_CONTEXT} && mv TencentCloudJvmMonitor-1.1.0-RELEASE.jar ./${env.DOCKER_BUILD_CONTEXT} && mv tsf-consul-template-docker.tar.gz ./${env.DOCKER_BUILD_CONTEXT}"
        sh "docker build -t ${env.CODING_DOCKER_IMAGE_NAME}:${env.RUNNING_ENV}-${env.DOCKER_IMAGE_VERSION} --build-arg jarpath=${env.JARPATH} ./${env.DOCKER_BUILD_CONTEXT}"
      }
    }
    stage('推送到 CODING Docker 制品库') {
      steps {
        script {
          docker.withRegistry(
            "${env.CCI_CURRENT_WEB_PROTOCOL}://${env.CODING_DOCKER_REG_HOST}",
            "${env.CODING_ARTIFACTS_CREDENTIALS_ID}"
          ) {
            docker.image("${CODING_DOCKER_IMAGE_NAME}:${env.RUNNING_ENV}-${env.DOCKER_IMAGE_VERSION}").push()
          }
        }

      }
    }
    stage('推送镜像到tsf') {
      steps {
        sh "echo ${env.TSF_REGISTRY_PASS} | docker login -u 100014116958 --password-stdin ccr.ccs.tencentyun.com"
        sh "docker tag ${env.CODING_DOCKER_IMAGE_NAME}:${env.RUNNING_ENV}-${env.DOCKER_IMAGE_VERSION} ccr.ccs.tencentyun.com/tsf_100014116958/${env.TSF_APP_NAME}:${env.RUNNING_ENV}-${env.DOCKER_IMAGE_VERSION}"
        sh "docker push ccr.ccs.tencentyun.com/tsf_100014116958/${env.TSF_APP_NAME}:${env.RUNNING_ENV}-${env.DOCKER_IMAGE_VERSION}"
      }
    }
  }
  environment {
    CODING_DOCKER_REG_HOST = "${env.CCI_CURRENT_TEAM}-docker.pkg.${env.CCI_CURRENT_DOMAIN}"
    CODING_DOCKER_IMAGE_NAME = "${env.PROJECT_NAME.toLowerCase()}/${env.DOCKER_REPO_NAME}/${env.DOCKER_IMAGE_NAME}"
  }
}
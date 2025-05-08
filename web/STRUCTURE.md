# Web 项目结构说明

## 目录结构

```
web/
├── node_modules/       # 依赖包目录
├── public/            # 静态资源目录
├── src/              # 源代码目录
├── .gitignore        # Git忽略文件配置
├── env.d.ts          # TypeScript环境声明文件
├── index.html        # 项目入口HTML文件
├── package.json      # 项目配置和依赖管理
├── package-lock.json # 依赖版本锁定文件
├── README.md         # 项目说明文档
├── tsconfig.json     # TypeScript主配置
├── tsconfig.app.json # TypeScript应用配置
├── tsconfig.node.json # TypeScript Node环境配置
└── vite.config.ts    # Vite构建工具配置
```

## 文件说明

### 配置文件

1. `package.json`
   - 项目的核心配置文件
   - 定义项目的名称、版本、依赖等信息
   - 包含项目的脚本命令（如启动、构建等）

2. `package-lock.json`
   - 锁定所有依赖包的具体版本
   - 确保团队成员使用相同的依赖版本
   - 由npm自动生成和维护

3. `vite.config.ts`
   - Vite构建工具的配置文件
   - 定义项目的构建规则
   - 配置开发服务器、插件等

4. `tsconfig.json`
   - TypeScript的主配置文件
   - 定义TypeScript编译选项
   - 指定项目范围和编译规则

5. `tsconfig.app.json`
   - 应用特定的TypeScript配置
   - 继承自tsconfig.json
   - 包含Vue应用相关的特定配置

6. `tsconfig.node.json`
   - Node.js环境下的TypeScript配置
   - 用于构建工具和Node.js脚本
   - 配置Node.js特定的编译选项

7. `.gitignore`
   - Git版本控制忽略规则
   - 指定不需要纳入版本控制的文件
   - 如node_modules、构建输出等

### 源代码目录

1. `src/`
   - 项目的源代码目录
   - 包含所有的Vue组件、工具函数等
   - 主要的开发工作目录

2. `src/components/`
   - Vue组件目录
   - 存放可复用的UI组件
   - 如LoginForm.vue等

3. `src/services/`
   - 服务层目录
   - 包含API调用、数据处理等服务
   - 如AuthService.ts处理登录认证

4. `src/types/`
   - TypeScript类型定义目录
   - 存放接口、类型声明等
   - 如auth.ts定义认证相关类型

5. `src/assets/`
   - 静态资源目录
   - 存放样式、图片等资源
   - 如base.css、main.css等

### 其他文件和目录

1. `node_modules/`
   - npm包依赖目录
   - 存放所有第三方依赖
   - 不应该提交到版本控制

2. `public/`
   - 静态资源目录
   - 不需要经过构建处理的文件
   - 会被直接复制到构建输出目录

3. `index.html`
   - 应用的HTML入口文件
   - 包含根节点和基本配置
   - Vite用作构建入口

4. `env.d.ts`
   - 环境变量的TypeScript类型声明
   - 确保TypeScript正确识别环境变量
   - 包含Vue等模块的类型声明

## 开发相关

- 开发服务器启动：`npm run dev`
- 项目构建：`npm run build`
- 代码检查：`npm run lint`
- 类型检查：`npm run type-check`

## 技术栈

- Vue 3：前端框架
- TypeScript：类型系统
- Vite：构建工具
- Axios：HTTP客户端 
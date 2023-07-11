<template>
	<el-main class="ex_main">
			<div v-if="JSON.parse(JSON.stringify(this.list)).length !== 0">
				<div class="jhlb" v-for="index in list" :key="index">
					<el-card class="box-card" shadow="hover">
						<template #header>
							<div class="card-header">
								<el-avatar style="overflow: hidden;">
									<img v-if="index.avatar" :src="tuPianUrl + index.avatar" />
									<img v-else src="/img/error.png" />
								</el-avatar>
								<span style="margin-left: 60px;display: block;margin-top: -35px;">{{ index.username
								}}</span>
								<span style="margin-left:490px;display: block;margin-top: -20px;">{{ index.planName
								}}</span>
								<div style="float: right;margin-top: 5px;">
									<el-button class="start shanchu" @click="delfxxd(index)">删除</el-button>
									<el-button class="start" style="margin-top: -60px;" @click="fhui()">返回</el-button>
								</div>
							</div>
						</template>
						<div class="minddle">
							<div class="minddle1">
								<div style="text-align: center;">
									<div>{{ index.content }}</div>
								</div>
							</div>
						</div>
						<div class="minddles">
							<div v-if="index.hits.length !== 0" style="display: flex;">
								<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024" version="1.1"
									xmlns="http://www.w3.org/2000/svg" p-id="2841" width="15" height="15">
									<path
										d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
													 67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208 
													 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 140.864-137.856 
													 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 102.72 0 0 0-100.928-121.824z"
										p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3" class="selected" fill="#fc5533">
									</path>
								</svg>
								<span v-for="index1 in index.hits" :key="index1" style="display: flex;">
									{{ index1.username }}，
								</span>
							</div>
						</div>
						<div class="footer">
							<span class="time">发布于 {{ index.createTime }}</span>
							<div class="sangeann">
								<span @click="dianzhan(index)" v-if="index.likes == null || index.likes == 0">
									<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024" version="1.1"
										xmlns="http://www.w3.org/2000/svg" p-id="2841"
										data-spm-anchor-id="a313x.7781069.0.i6" width="15" height="15">
										<path d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
												67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208
												 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 
												 140.864-137.856 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 
												 102.72 0 0 0-100.928-121.824z" p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3" class="" fill="#2c2c2c">
										</path>
									</svg>点赞</span>
								<span @click="dianzhan1(index)" v-else>
									<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024" version="1.1"
										xmlns="http://www.w3.org/2000/svg" p-id="2841" width="15" height="15">
										<path
											d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
													 67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208 
													 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 140.864-137.856 
													 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 102.72 0 0 0-100.928-121.824z"
											p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3" class="selected"
											fill="#fc5533"></path>
									</svg>取消点赞</span>
							</div>
						</div>
						<div style="margin-top: 10px;">
							<div :inline="true">
								<el-input v-model="textarea1" autosize type="textarea" placeholder="写下你的评论..."
									style="width: 990px;margin-right: 10px;" />
								<el-button type="primary" @click="fabu(index)">发布</el-button>
							</div>
							<div style="margin-top: 10px;">
								<div class="jtpl">{{ index.plts }}条评论</div>
								<div class="pl" v-if="index.plts != 0">
									<div v-for="index3 in index.commentList" :key="index3">
										<div style="padding-top: 10px;padding-left: 20px;padding-bottom: 10px;width: 1100px;"
											@click.stop="huifu(index3)">
											<div v-if="index3.reusername == index3.reusername">
												<el-avatar style="overflow: hidden;">
													<img v-if="index3.avatar" :src="tuPianUrl + index3.avatar" />
													<img v-else src="/img/error.png" />
												</el-avatar>
												<span style="margin-left: 60px;display: block;margin-top: -35px;">{{
													index3.username }}
													<span  v-if="index3.userGroup==='管理员'"><button>管理员</button></span>
													<span  v-else-if="index3.userGroup==='教师'"><button>教师</button></span></span>
												<span @click.stop="delpl(index3)"
													style="margin-left: 980px;color: red;cursor: pointer;display: block;margin-top: -20px;">删除</span>
											</div>
											<div v-else>
												<el-avatar style="overflow: hidden;">
													<img v-if="index3.avatar" :src="tuPianUrl + index3.avatar" />
													<img v-else src="/img/error.png" />
												</el-avatar>
												<span style="margin-left: 60px;display: block;margin-top: -35px;">
													{{ index3.username }} <el-icon>
														<CaretRight />
													</el-icon>{{ index3.reusername }}
													<span  v-if="index3.userGroup==='管理员'"><button>管理员</button></span>
													<span  v-else-if="index3.userGroup==='教师'"><button>教师</button></span></span>
												<span @click.stop="delpl(index3)"
													style="margin-left: 980px;color: red;cursor: pointer;display: block;margin-top: -20px;">删除</span>
											</div>
											<div class="plnr">
												<div>{{ index3.content }}</div>
											</div>
											<span
												style="margin-left: 60px;display: block;margin-top: 10px;">{{ index3.createTime }}</span>
											<div style="margin-left: 980px;margin-top: -20px;">
												<span @click.stop="dianzhan3(index3)"
													v-if="index3.likes == null || index3.likes == 0">
													<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024"
														version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2841"
														data-spm-anchor-id="a313x.7781069.0.i6" width="15" height="15">
														<path d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
												67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208
												 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 
												 140.864-137.856 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 
												 102.72 0 0 0-100.928-121.824z" p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3" class="" fill="#2c2c2c">
														</path>
													</svg><span v-if="index3.hits.length != 0" style="cursor: pointer;">{{ index3.hits.length
													}}</span><span v-else style="cursor: pointer;">赞</span></span>
												<span @click.stop="dianzhan4(index3)" v-else>
													<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024"
														version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2841"
														width="15" height="15">
														<path
															d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
													 67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208 
													 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 140.864-137.856 
													 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 102.72 0 0 0-100.928-121.824z"
															p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3"
															class="selected" fill="#fc5533"></path>
													</svg><span style="cursor: pointer;">{{ index3.hits.length }}</span></span>
											</div>
										</div>
										<div v-if="index3.comments.length != 0">
											<div v-for="index4 in index3.comments" :key="index4">
											<div style="padding-top: 10px;padding-left: 80px;padding-bottom: 10px;width: 1100px;"
											@click.stop="huifu1(index4)">
											<div v-if="index4.username == index4.reusername">
												<el-avatar style="overflow: hidden;">
													<img v-if="index4.avatar" :src="tuPianUrl + index4.avatar" />
													<img v-else src="/img/error.png" />
												</el-avatar>
												<span style="margin-left: 60px;display: block;margin-top: -35px;">{{index4.username }}
													<span  v-if="index4.userGroup==='管理员'"><button>管理员</button></span>
													<span  v-else-if="index4.userGroup==='教师'"><button>教师</button></span></span>
												<span @click.stop="delpl1(index4)"
													style="margin-left: 920px;color: red;cursor: pointer;display: block;margin-top: -20px;">删除</span>
											</div>
											<div v-else>
												<el-avatar style="overflow: hidden;">
													<img v-if="index4.avatar" :src="tuPianUrl + index4.avatar" />
													<img v-else src="/img/error.png" />
												</el-avatar>
												<span style="margin-left: 60px;display: block;margin-top: -35px;">
													{{ index4.username }} <el-icon>
														<CaretRight />
													</el-icon>{{ index4.reusername }}
													<span  v-if="index4.userGroup==='管理员'"><button>管理员</button></span>
													<span  v-else-if="index4.userGroup==='教师'"><button>教师</button></span></span>
												<span @click.stop="delpl1(index4)"
													style="margin-left: 920px;color: red;cursor: pointer;display: block;margin-top: -20px;">删除</span>
											</div>
											<div class="plnr1">
												<div>{{ index4.content }}</div>
											</div>
											<span style="margin-left: 60px;display: block;margin-top: 10px;">{{ index4.createTime }}</span>
											<div style="margin-left: 920px;margin-top: -20px;">
												<span @click.stop="dianzhan5(index4)"
													v-if="index4.likes == null || index4.likes == 0">
													<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024"
														version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2841"
														data-spm-anchor-id="a313x.7781069.0.i6" width="15" height="15">
														<path d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
												67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208
												 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 
												 140.864-137.856 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 
												 102.72 0 0 0-100.928-121.824z" p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3" class="" fill="#2c2c2c">
														</path>
													</svg><span v-if="index4.hits.length != 0" style="cursor: pointer;">{{ index4.hits.length
													}}</span><span v-else style="cursor: pointer;">赞</span></span>
												<span @click.stop="dianzhan6(index4)" v-else>
													<svg t="1681215982915" class="icon" viewBox="0 0 1024 1024"
														version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2841"
														width="15" height="15">
														<path
															d="M64 483.04V872c0 37.216 30.144 67.36 67.36 67.36H192V416.32l-60.64-0.64A67.36 
													 67.36 0 0 0 64 483.04zM857.28 344.992l-267.808 1.696c12.576-44.256 18.944-83.584 18.944-118.208 
													 0-78.56-68.832-155.488-137.568-145.504-60.608 8.8-67.264 61.184-67.264 126.816v59.264c0 76.064-63.84 140.864-137.856 
													 148L256 416.96v522.4h527.552a102.72 102.72 0 0 0 100.928-83.584l73.728-388.96a102.72 102.72 0 0 0-100.928-121.824z"
															p-id="2842" data-spm-anchor-id="a313x.7781069.0.i3"
															class="selected" fill="#fc5533"></path>
													</svg><span style="cursor: pointer;">{{ index4.hits.length }}</span></span>
											</div>
										</div>
											</div>
										</div>
									</div>
								</div>
								<div class="pl" style="height: 500px;text-align: center;padding-top: 100px;" v-else>
									<img src="../../../public/tz/kkry.jpg" />
									<div>还没有评论，发表第一个评论吧</div>
								</div>
							</div>
						</div>
					</el-card>
				</div>
			</div>
			<div v-else style="height: 370px;text-align: center;padding-top: 100px;">
				<img src="../../../public/tz/kkry.jpg" />
				<div>还没有人分享，请尽快分享吧</div>
			</div>
		<!-- --对话框-- -->
		<el-dialog title="心得分享" v-model="centerDialogVisible" width="50%" center>
			<el-form ref="form1" :model="form1" :rules="rules" label-width="80px">
				<el-form-item label="接收方" prop="reusername">
					<el-select v-model="form1.reusername" filterable placeholder="请选择或输入你想给谁分享的用户名" allow-create
						style="width: 1000px;">
						<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer" style="margin-left: 285px;">
				<el-button @click="centerDialogVisible = false">取 消</el-button>
				<el-button type="primary" @click="submit()">确 定</el-button>
			</span>
		</el-dialog>
		<el-dialog title="评论回复" v-model="centerDialogVisible1" width="50%" center>
			<el-form ref="form2" :model="form2" :rules="rules" label-width="80px">
				<el-form-item label="" prop="textarea">
					<el-input id="pla" v-model="form2.textarea" autosize type="textarea" placeholder="回复"
					style="width: 590px;margin-right: 10px;" />
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer" style="margin-left: 285px;">
				<el-button @click="centerDialogVisible1 = false">取 消</el-button>
				<el-button type="primary" @click="fabu1()">发布</el-button>
			</span>
		</el-dialog>
	</el-main>
</template>

<script>
import { CaretRight, Comment, Pointer, Promotion } from '@element-plus/icons-vue';
// let data = JSON.parse(sessionStorage.getItem("user"))
let username = sessionStorage.getItem("username");
import router from '../../router';
import { ElMessage, ElMessageBox } from 'element-plus'
export default {
	data() {
		return {
			username: username,
			list: [],
			dz: 1,
			qxdz: 0,
			tuPianUrl: 'http://localhost:8080',
			centerDialogVisible: false,
			centerDialogVisible1: false,
			options: [],
			form1: {
				planName: '',
				reusername: '',
				textarea: '',
			},
			textarea1: '',
			form2: {
				commentId: '',
				reusername: '',
				textarea: '',
			},
		};
	},
	methods: {
		xianshi() {
			this.axios.post("/communication/xdfxList1", {
				id:this.$route.query.communicationId,
				username:username
			})
				.then(res => res.data).then(res => {
					if (res.code == 200) {
						console.log(res.data);
						this.list = res.data;
					}
					else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: "数据查询失败",
							type: "error"
						});
						router.push("/experience/view").then(() => {
							setTimeout(router.go(0), 0);
						});
					}
				});
		}, fxxd(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			this.centerDialogVisible = true;
			this.form1.textarea = index1.content,
				this.form1.planName = index1.planName
			this.$nextTick(() => {
				this.$refs.form1.resetFields(); //刷新
			})
		}, submit() {
			this.axios.post('/experience/fxxd', {
				username: username,
				planName: this.form1.planName,
				reusername: this.form1.reusername,
				textarea: this.form1.textarea
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '心得分享成功',
							type: 'success'
						});
						this.xianshi();
						this.centerDialogVisible = false;
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '心得分享失败',
							type: 'error'
						});
						this.centerDialogVisible = false;
					}
				}
				)
		}, dianzhan(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			this.axios.post('/communication/dianzhan', {
				username: username,
				communicationId: index1.communicationId,
				dz: this.dz,
				type: '交流'
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '点赞成功',
							type: 'success'
						});
						this.xianshi();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '点赞失败',
							type: 'error'
						});
					}
				}
				)
		}, dianzhan1(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			this.axios.post('/communication/qxdz', {
				username: username,
				communicationId: index1.communicationId,
				qxdz: this.qxdz,
				type: '交流'
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '取消点赞成功',
							type: 'success'
						});
						this.xianshi();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '取消点赞失败',
							type: 'error'
						});
					}
				}
				)
		}, delfxxd(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			ElMessageBox.confirm(
				'是否确认删除该心得',
				'注意',
				{
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
				}
			)
				.then(() => {
					this.axios.post('/communication/jsscfxxd', {
						communicationId: index1.communicationId,
						username:username,
						reusername:index1.username
					})
						.then(res => res.data).then(res => {
							// console.log(res);
							if (res.code == 200) {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除成功',
									type: 'success'
								});
								router.push("/experience/view").then(() => {
									setTimeout(router.go(0), 0);
								});
							} else {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除失败',
									type: 'error'
								});
							}
						}
						)
				})
				.catch(() => {
					ElMessage({
						type: 'info',
						message: '已取消删除',
					})
				})
		}, fabu(index) {
			let index1 = JSON.parse(JSON.stringify(index));
			if (this.textarea1 != '') {
				this.axios.post('/communication/fabu', {
					username: username,
					reusername: index1.username,
					communicationId: index1.communicationId,
					textarea1: this.textarea1,
					type:'交流'
				})
					.then(res => res.data).then(res => {
						// console.log(res);
						if (res.code == 200) {
							this.$message({
								duration: 3000,
								offset: 50,
								message: '评论发布成功',
								type: 'success'
							});
							this.xianshi();
							this.textarea1 = '';
						} else {
							this.$message({
								duration: 3000,
								offset: 50,
								message: '评论发布失败',
								type: 'error'
							});
						}
					}
					)
			} else {
				this.$message({
					duration: 3000,
					offset: 50,
					message: '请先填写评论',
					type: 'success'
				});
			}
		}, delpl(index3) {
			let index1 = JSON.parse(JSON.stringify(index3));
			// console.log(index1)
			ElMessageBox.confirm(
				'是否确认删除该评论',
				'注意',
				{
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
				}
			)
				.then(() => {
					if(index1.username===username){
						this.axios.post('/communication/delpl', {
						commentId: index1.commentId,
					})
						.then(res => res.data).then(res => {
							// console.log(res);
							if (res.code == 200) {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除成功',
									type: 'success'
								});
								this.xianshi();
							} else {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除失败',
									type: 'error'
								});
							}
						}
						)
					}else{
						this.axios.post('/communication/jsdelpl', {
						commentId: index1.commentId,
						id: index1.id,
						username:username,
						reusername:index1.username
					})
						.then(res => res.data).then(res => {
							// console.log(res);
							if (res.code == 200) {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除成功',
									type: 'success'
								});
								this.xianshi();
							} else {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除失败',
									type: 'error'
								});
							}
						}
						)
					}
				})
				.catch(() => {
					ElMessage({
						type: 'info',
						message: '已取消删除',
					})
				})
		}, dianzhan3(index3) {
			let index1 = JSON.parse(JSON.stringify(index3));
			this.axios.post('/communication/dianzhan', {
				username: username,
				communicationId: index1.commentId,
				dz: this.dz,
				type: '评论'
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '点赞成功',
							type: 'success'
						});
						this.xianshi();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '点赞失败',
							type: 'error'
						});
					}
				}
				)
		}, dianzhan4(index3) {
			let index1 = JSON.parse(JSON.stringify(index3));
			this.axios.post('/communication/qxdz', {
				username: username,
				communicationId: index1.commentId,
				qxdz: this.qxdz,
				type: '评论'
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '取消点赞成功',
							type: 'success'
						});
						this.xianshi();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '取消点赞失败',
							type: 'error'
						});
					}
				}
				)
		}, huifu(index3) {
			let index1 = JSON.parse(JSON.stringify(index3));
			this.centerDialogVisible1 = true;
			this.form2.commentId=index1.commentId;
			this.form2.reusername=index1.username;
			document.getElementById("pla").placeholder="回复"+index1.username;
		},fabu1(){
			if ( this.form2.textarea != '') {
				this.axios.post('/communication/fabu', {
					username: username,
					reusername: this.form2.reusername,
					communicationId: this.form2.commentId,
					textarea1: this.form2.textarea,
					type:'评论'
				})
					.then(res => res.data).then(res => {
						// console.log(res);
						if (res.code == 200) {
							this.$message({
								duration: 3000,
								offset: 50,
								message: '评论发布成功',
								type: 'success'
							});
							this.xianshi();
							this.form2.textarea = '';
							this.centerDialogVisible1 = false;
						} else {
							this.$message({
								duration: 3000,
								offset: 50,
								message: '评论发布失败',
								type: 'error'
							});
							this.centerDialogVisible1 = false;
						}
					}
					)
			} else {
				this.$message({
					duration: 3000,
					offset: 50,
					message: '请先填写评论',
					type: 'success'
				});
			}
		},huifu1(index4) {
			let index1 = JSON.parse(JSON.stringify(index4));
			this.centerDialogVisible1 = true;
			this.form2.commentId=index1.id;
			this.form2.reusername=index1.username;
			document.getElementById("pla").placeholder="回复"+index1.username;
		},delpl1(index4){
			let index1 = JSON.parse(JSON.stringify(index4));
			// console.log(index1)
			ElMessageBox.confirm(
				'是否确认删除该评论',
				'注意',
				{
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
				}
			)
				.then(() => {
					if(index1.username===username){
						this.axios.post('/communication/delpl', {
						commentId: index1.commentId,
					})
						.then(res => res.data).then(res => {
							// console.log(res);
							if (res.code == 200) {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除成功',
									type: 'success'
								});
								this.xianshi();
							} else {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除失败',
									type: 'error'
								});
							}
						}
						)
					}else{
						this.axios.post('/communication/jsdelpl', {
						commentId: index1.commentId,
						id: index1.id,
						username:username,
						reusername:index1.username
					})
						.then(res => res.data).then(res => {
							// console.log(res);
							if (res.code == 200) {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除成功',
									type: 'success'
								});
								this.xianshi();
							} else {
								this.$message({
									duration: 3000,
									offset: 50,
									message: '删除失败',
									type: 'error'
								});
							}
						}
						)
					}
				})
				.catch(() => {
					ElMessage({
						type: 'info',
						message: '已取消删除',
					})
				})
		}, dianzhan5(index4) {
			let index1 = JSON.parse(JSON.stringify(index4));
			this.axios.post('/communication/dianzhan', {
				username: username,
				communicationId: index1.commentId,
				dz: this.dz,
				type: '评论'
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '点赞成功',
							type: 'success'
						});
						this.xianshi();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '点赞失败',
							type: 'error'
						});
					}
				}
				)
		}, dianzhan6(index4) {
			let index1 = JSON.parse(JSON.stringify(index4));
			this.axios.post('/communication/qxdz', {
				username: username,
				communicationId: index1.commentId,
				qxdz: this.qxdz,
				type: '评论'
			})
				.then(res => res.data).then(res => {
					// console.log(res);
					if (res.code == 200) {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '取消点赞成功',
							type: 'success'
						});
						this.xianshi();
					} else {
						this.$message({
							duration: 3000,
							offset: 50,
							message: '取消点赞失败',
							type: 'error'
						});
					}
				}
				)
		},fhui(){
			router.push("/experience/view").then(() => {
				setTimeout(router.go(0), 0);
			});
		}
	}, beforeMount() {
		this.xianshi();
	}, components: { Promotion, Comment, Pointer, CaretRight }
}
</script>

<style>
.ex_main {
	padding: 2rem 1rem;
	background-color: #eeeeee !important;
	width: 90%;
	height: 92vh;
	margin: 0 auto;
	padding: 0;
}

.jhlb {
	display: block;
	margin-left: 55px;
}

.time {
	display: block;
	/* margin-left: -55px; */
	/* text-align: center; */
}

.el-form-item__content {
	font-size: 20px;
}

.el-card {
	width: 1100px;
	margin-top: 20px;
	margin-bottom: 20px;
}

.myxx {
	text-align: center;
	margin-top: 10px;
	width: 100%;
	height: 100px;
	padding-top: 50px;
	font-size: 30px;
	background-color: #fff;
}

.start {
	margin-top: -60px;
	margin-left: 20px;
	border-radius: 30%;
	font-weight: 700;
	/* 字变斜 */
	font-style: oblique;
	color: #027cff;
	background-color: rgb(193, 231, 255);
}

.start:hover {
	margin-top: -60px;
	margin-left: 20px;
	border-radius: 30%;
	font-weight: 700;
	/* 字变斜 */
	font-style: oblique;
	color: #027cff;
	background-color: rgb(193, 231, 255);
}

.shanchu {
	font-weight: 700;
	color: #fb0000;
	background-color: rgb(247, 179, 179);
}

.shanchu:hover {
	font-weight: 700;
	color: #fb0000;
	background-color: rgb(247, 179, 179);
}

.sangeann {
	float: left;
	display: block;
	margin-left: 20px;
}

.sangeann span {
	margin-left: 30px;
	cursor: pointer;
}

.minddle {
	width: 100%;
	border-radius: 20px 20px;
	color: #000000;
	background-color: rgb(193, 231, 255);
}

.minddle1 {
	margin-left: 20px;
	margin-right: 20px;
	padding-top: 7px;
	padding-bottom: 7px;
}

.minddles {
	width: 100%;
	margin-top: 10px;
	border-radius: 20px 20px;
	color: #000000;
	/* display: flex; */
	background-color: rgb(203, 203, 203);
}

.minddles span {
	margin-left: 10px;
	/* float: left; */
	padding-bottom: 5px;
	padding-top: 5px;
}

.minddles svg {
	padding-top: 5px;
	padding-bottom: 5px;
	margin-left: 10px;
}

.footer {
	margin-top: 20px;
	display: flex;
}

.jtpl {
	height: 35px;
	padding-top: 15px;
	text-align: center;
	font-weight: 800;
	border: solid 2px #eeeeee;
}

.pl {
	width: 1056px;
	border: solid 2px #eeeeee;
}

.plnr {
	width: 900px;
	padding-right: 20px;
	margin-left: 60px;
	margin-top: 10px;
}
.plnr1 {
	width: 940px;
	padding-right: 20px;
	margin-left: 60px;
	margin-top: 10px;
}
.el-tabs--top .el-tabs__item.is-top:nth-child(2) {
	padding-left: 120px;
}

.el-tabs__item {
	padding-left: 120px;
}

.el-tabs {
	width: 820px;
	/* position: fixed; */
}

.el-form-item__label {
	color: #00838F !important;
}</style>
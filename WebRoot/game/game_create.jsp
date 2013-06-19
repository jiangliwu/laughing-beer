<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java"
	import="com.opensymphony.xwork2.ActionContext,java.util.*"%>
<html>
<head>
<title>Laughing-beer - 游戏大厅</title>
<%@taglib uri="/struts-tags" prefix="s"%>
</head>
<body>



	<div class="container">
		<ul class="breadcrumb">
			<li><a href="index">首页</a> <span class="divider">/</span>
			</li>
			<li class="active">创建游戏</li>



		</ul>



		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span8">

					<s:form cssClass="form-horizontal" action="game_create!create">

						<div class="control-group">
							<label class="control-label">房间标题</label>
							<div class="controls">
								<s:textfield name="gameTitle" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">零售商人数</label>
							<div class="controls">
								<s:textfield name="retailNumber" value="1" readonly="true" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">批发商人数</label>
							<div class="controls">
								<s:textfield name="wholesaleNumber" value="1" readonly="true" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">生产商人数</label>
							<div class="controls">
								<s:textfield name="producerNumber" value="1" readonly="true" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">游戏周数</label>
							<div class="controls">
								<s:textfield name="times" value="50" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">每一周操作时间长度(秒)</label>
							<div class="controls">
								<s:textfield name="time" value="30" />
							</div>
						</div>
						<div class="control-group offset2">

							<div class="checkbox">
								<s:checkbox name="needPassword" id="need-password">是否需要密码</s:checkbox>
							</div>
						</div>

						<div class="control-group" id="password-input"
							style="display:none">
							<label class="control-label">房间密码</label>
							<div class="controls">
								<s:textfield name="password"></s:textfield>
							</div>
						</div>




						<hr class="soften">
						<p>
							<a class="offset2" rel="tooltips" title="零售商的详细参数配置" href="#"
								id="retail-config">点击这里配置零售商的参数</a>
						</p>
						<div id="retail-input" style="display:none">
							<div class="control-group">
								<label class="control-label">零售价</label>
								<div class="controls">
									<s:textfield name="retail.price" value="30" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">成本</label>
								<div class="controls">
									<s:textfield name="retail.cost" value="20" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">延迟销售成本</label>
								<div class="controls">
									<s:textfield name="retail.delayCost" value="3" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">库存成本</label>
								<div class="controls">
									<s:textfield name="retail.repertoryCost" value="1" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">订单手续费</label>
								<div class="controls">
									<s:textfield name="retail.orderCost" value="10" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">到货运输费</label>
								<div class="controls">
									<s:textfield name="retail.transportCost" value="10" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">期末折价率</label>
								<div class="controls">
									<s:textfield name="retail.discount" value="50" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">初期库存</label>
								<div class="controls">
									<s:textfield name="retail.origin" value="%{randomRetail}" />
								</div>
							</div>
						</div>



						<hr class="soften">
						<p>
							<a class="offset2" title="批发商的详细参数配置" href="#"
								id="wholesale-config">点击这里配置批发商的参数</a>
						</p>
						<div id="wholesale-input" style="display:none">
							<div class="control-group">
								<label class="control-label">批发价</label>
								<div class="controls">
									<s:textfield name="wholesale.price" value="20" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">成本</label>
								<div class="controls">
									<s:textfield name="wholesale.cost" value="15" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">延迟销售成本</label>
								<div class="controls">
									<s:textfield name="wholesale.delayCost" value="1.5" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">库存成本</label>
								<div class="controls">
									<s:textfield name="wholesale.repertoryCost" value="0.3" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">订单手续费</label>
								<div class="controls">
									<s:textfield name="wholesale.orderCost" value="15" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">到货运输费</label>
								<div class="controls">
									<s:textfield name="wholesale.transportCost" value="15" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">期末折价率</label>
								<div class="controls">
									<s:textfield name="wholesale.discount" value="50" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">初期库存</label>
								<div class="controls">
									<s:textfield name="wholesale.origin" value="%{randomWholesale}" />
								</div>
							</div>
						</div>


						<hr class="soften">
						<p>
							<a class="offset2" rel="tooltips" title="生产商的详细参数配置" href="#"
								id="producer-config">点击这里配置生产商的参数</a>
						</p>
						<div id="producer-input" style="display:none">
							<div class="control-group">
								<label class="control-label">批发价</label>
								<div class="controls">
									<s:textfield name="producer.price" value="15" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">成本</label>
								<div class="controls">
									<s:textfield name="producer.cost" value="11" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">延迟销售成本</label>
								<div class="controls">
									<s:textfield name="producer.delayCost" value="1.2" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">库存成本</label>
								<div class="controls">
									<s:textfield name="producer.repertoryCost" value="0.15" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">生产线启动</label>
								<div class="controls">
									<s:textfield name="producer.startCost" value="30" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">期末折价率</label>
								<div class="controls">
									<s:textfield name="producer.discount" value="50" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">初期库存</label>
								<div class="controls">
									<s:textfield name="producer.origin" value="%{randomProducer}" />
								</div>
							</div>
						</div>

						<div class="form-actions">
							<button type="submit" class="btn btn-large btn-primary offset1">创建游戏房间</button>

						</div>
					</s:form>

				</div>
				<div class="span3 offset1">

					<ul class="nav nav-tabs nav-stacked">

						<li class="active"><s:a action="game_create!index">创建游戏</s:a>
						</li>
						<li><s:a action="game_hall!runing">进行中的游戏</s:a></li>
						<li><s:a action="game_hall">等待中的游戏</s:a></li>
						<li><s:a action="game_hall!mygame">我创建的游戏</s:a></li>
					</ul>

				</div>
			</div>
		</div>
	</div>



</body>

</html>



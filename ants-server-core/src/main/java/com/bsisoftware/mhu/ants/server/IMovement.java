package com.bsisoftware.mhu.ants.server;

import com.bsisoftware.mhu.ants.server.api.Food;
import com.bsisoftware.mhu.ants.shared.util.Point;
import com.bsisoftware.mhu.ants.shared.util.RandomUtil;

public interface IMovement {

	Point getNextPosition(Point currentPosition, int distance);

	public static class Search implements IMovement {

		private final Point origin;

		public Search(Point origin) {
			this.origin = origin; 
		}

		public Point getOrigin() {
			return origin;
		}

		@Override
		public Point getNextPosition(Point currentPosition, int distance) {
			Point tr = RandomUtil.createTranslation(distance);
			return currentPosition.translate(tr);
		}
	}

	public static class Travel implements IMovement {

		private final Point origin;
		private final Point target;

		public Travel(Point origin, Point target) {
			this.origin = origin;
			this.target = target;
		}

		public Point getOrigin() {
			return origin;
		}
		
		public Point getTarget() {
			return target;
		}
		
		@Override
		public Point getNextPosition(Point currentPosition, int distance) {
			Point move = currentPosition.stepTowards(target, distance);
			return currentPosition.translate(move);
		}
	}
	
	public static class Transport extends Travel {
		private final Food payload;

		public Transport(Point target, Food payload) {
			super(payload.getPosition(), target);
			this.payload = payload;
		}

		public Food getPayload() {
			return payload;
		}
	}
}

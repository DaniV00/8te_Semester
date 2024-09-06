package de.uni_ulm.sp.oop.collections;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;
import static guru.nidi.graphviz.model.Factory.to;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

import javax.swing.SwingUtilities;

import guru.nidi.graphviz.attribute.Font;
import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.attribute.Rank;
import guru.nidi.graphviz.attribute.Rank.RankDir;
import guru.nidi.graphviz.attribute.Shape;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.LinkSource;
import guru.nidi.graphviz.model.Node;

public class CollectionVisualizer {

	private static Stack visualizedObject = createStack();

	private static Stack createStack() {
		var s = new Stack();
		s.push(12);
		s.push(14);
		s.push(42);
		return s;
	}

	private static LList createList() {
		var l = new LList();
		l.add(12);
		l.add(14);
		l.add(42);
		return l;
	}

	private static InheritingStack createInheritingStack() {
		var l = new InheritingStack();
		l.push(12);
		l.push(14);
		l.push(42);
		return l;
	}

	private static GenericsLList<Integer> createGenericsInheritingStack() {
		var l = new GenericsInheritingStack<Integer>();
		l.add(new Integer[] { 12, 14, 42 });
		return l;
	}

	private static GenericsLList<Integer> createGenericsInheritingStackWithChangedOrder() {
		var l = new GenericsInheritingStackWithChangedOrder<Integer>();
		l.add(new Integer[] { 12, 14, 42 });
		return l;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					createFrame();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	private static void createFrame() throws IOException {

		Frame frame = new Frame();

		var data = visualizedObject;
		var image = renderGraph(data);
		var scrollPane = new ScrollPane();

		scrollPane.add(new Panel() {
			public void paint(Graphics g) {
				super.paint(g);
				g.drawImage(image, 0, 0, this);
			};

			public Dimension getPreferredSize() {
				return new Dimension(image.getWidth(null), 100);
			}
		});
		frame.add(scrollPane);

		// Setting Frame width and height
		frame.setSize(1400, 300);

		// Setting the title of Frame
		frame.setTitle("SOBS - Static Object Browsing System");

		/*
		 * By default frame is not visible so
		 * we are setting the visibility to true
		 * to make it visible.
		 */
		frame.setVisible(true);
	}

	private static LinkSource createNode(StackElement element) {
		Node node;
		if (element.getNext() != null) {
			node = node(element.toString()).with(Shape.BOX).link(
					to(node(element.getNext().toString())).with(Label.of("next")));
		} else {
			node = node(element.toString()).with(Shape.BOX);
		}
		return node.link(to(node(element.getValue().toString()).with(Shape.BOX)).with(Label.of("value")));
	}

	private static LinkSource createNode(Stack stack) {
		if (stack.getHead() == null) {
			return node(stack.toString()).with(Shape.BOX);
		} else {
			return node(stack.toString()).with(Shape.BOX).link(
					to(node(stack.getHead().toString())).with(Label.of("head")));
		}
	}

	private static LinkSource createNode(ListElement element) {
		Node node;
		if (element.getNext() != null) {
			node = node(element.toString()).with(Shape.BOX).link(
					to(node(element.getNext().toString())).with(Label.of("next")));
		} else {
			node = node(element.toString()).with(Shape.BOX);
		}
		return node.link(to(node(element.getValue().toString()).with(Shape.BOX)).with(Label.of("value")));
	}

	private static LinkSource createNode(GenericsListElement<?> element) {
		Node node;
		if (element.getNext() != null) {
			node = node(element.toString()).with(Shape.BOX).link(
					to(node(element.getNext().toString())).with(Label.of("next")));
		} else {
			node = node(element.toString()).with(Shape.BOX);
		}
		return node.link(to(node(element.getValue().toString()).with(Shape.BOX)).with(Label.of("value")));
	}

	private static LinkSource createNode(LList list) {
		if (list.getHead() == null) {
			return node(list.toString()).with(Shape.BOX);
		} else {
			return node(list.toString()).with(Shape.BOX).link(
					to(node(list.getHead().toString())).with(Label.of("head")));
		}
	}

	private static LinkSource createNode(GenericsLList<?> list) {
		if (list.getHead() == null) {
			return node(list.toString()).with(Shape.BOX);
		} else {
			return node(list.toString()).with(Shape.BOX).link(
					to(node(list.getHead().toString())).with(Label.of("head")));
		}
	}

	private static Image renderGraph(Stack stack) throws IOException {

		var nodes = new LinkedList<LinkSource>();
		nodes.add(createNode(stack));
		var element = stack.getHead();
		while (element != null) {
			nodes.add(createNode(element));
			element = element.getNext();
		}

		Graph g = graph("example1").directed()
				.graphAttr().with(Rank.dir(RankDir.LEFT_TO_RIGHT))
				.nodeAttr().with(Font.name("arial"), Font.size(12))
				.linkAttr().with("class", "link-class")
				.with(nodes);

		return Graphviz.fromGraph(g).width(1400).render(Format.PNG).toImage();
	}

	private static Image renderGraph(LList list) throws IOException {

		var nodes = new LinkedList<LinkSource>();
		nodes.add(createNode(list));
		var element = list.getHead();
		while (element != null) {
			nodes.add(createNode(element));
			element = element.getNext();
		}

		Graph g = graph("example1").directed()
				.graphAttr().with(Rank.dir(RankDir.LEFT_TO_RIGHT))
				.nodeAttr().with(Font.name("arial"), Font.size(12))
				.linkAttr().with("class", "link-class")
				.with(nodes);

		return Graphviz.fromGraph(g).width(1400).render(Format.PNG).toImage();
	}

	private static Image renderGraph(GenericsLList<?> list) throws IOException {

		var nodes = new LinkedList<LinkSource>();
		nodes.add(createNode(list));
		var element = list.getHead();
		while (element != null) {
			nodes.add(createNode(element));
			element = element.getNext();
		}

		Graph g = graph("example1").directed()
				.graphAttr().with(Rank.dir(RankDir.LEFT_TO_RIGHT))
				.nodeAttr().with(Font.name("arial"), Font.size(12))
				.linkAttr().with("class", "link-class")
				.with(nodes);

		return Graphviz.fromGraph(g).width(1400).render(Format.PNG).toImage();
	}

}
